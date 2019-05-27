class PostsViewer{

    constructor(){
        this.postsCollection = new PostList(JSON.parse(localStorage.getItem('main')));
        this.numOfPosts = JSON.parse(localStorage.getItem('posts_number'));
        this.currentUser = JSON.parse(localStorage.getItem('current_user'));
        for (let i = 0; i < this.numOfPosts; i++) {
            let post = this.postsCollection._photoPosts[i];
            this.newHtmlPost(post);
        }
    }

    newHtmlPost(post) {
        if(!this.postsCollection._photoPosts.includes(post)) {
            this.postsCollection.add(post);
        }
        let main = document.getElementById('main');
        let article = document.createElement('article');
        article.setAttribute('id', post.id);
        let img = document.createElement('img');
        img.src = post.photoLink;
        article.appendChild(img);
        main.appendChild(article);
    }

    updateLent(){
        document.getElementById('main').remove();
        let main = document.createElement('main');
        main.setAttribute('id', 'main');
        document.getElementById('body').appendChild(main);
        for (let i = 0; i < this.numOfPosts; i++) {
            let post = this.postsCollection._photoPosts[i];
            this.newHtmlPost(post);
        }
    }

    removePost(id)
    {
        if(this.postsCollection.get(id).author === this.currentUser)
        {
            this.numOfPosts--;
            this.postsCollection.remove(id);

            localStorage.setItem('main', JSON.stringify(this.postsCollection._photoPosts));
            localStorage.setItem('posts_number', JSON.stringify(this.numOfPosts));
            document.getElementById(id).remove();
            return true;
        }
        return false;
    }

    editPost(id, config) {
        let post = this.postsCollection.get(id);
        if ((post && post.author === this.currentUser)) {
            if (this.postsCollection.edit(id, config)) {
                localStorage.setItem('main', JSON.stringify(this.postsCollection._photoPosts));
                this.updateLent();
                return true;
            }
            return false;
        }
    }

    
    
}

localStorage.setItem('current_user', JSON.stringify('Иванов Иван'));

const PV = new PostsViewer(photoPosts);


PV.editPost('1', {description: 'sasatb'});
