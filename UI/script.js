var photoPostProperties = [
    'id', 'description', 'createdAt', 'author', 'hashTags', 'photoLink'
];

class PostList {
    constructor(posts) {
        this._photoPosts = posts;
    }
    getPage(skip = 0, top = 10, filterConfig) {
        return this._photoPosts.filter(post =>
            (!filterConfig.authors.length || filterConfig.authors.includes(post.author))
            && (
                (!filterConfig.hasOwnProperty('fromDate') || post.createdAt.getTime() >= filterConfig.fromDate.getTime())
            && (!filterConfig.hasOwnProperty('toDate') || post.createdAt.getTime() <= filterConfig.toDate.getTime())
            )
            && (
            !filterConfig.hashTags.length || post.hashTags.includes(filterConfig.hashTags)
            ))
            .sort(function(a, b) { return a.createdAt.getTime() - b.createdAt.getTime();})
            .slice(skip, skip + top);
    }
    get(id) {
        return this._photoPosts.find(post => post.id == id);
    }
    add(photoPost) {
        if (PostList.validate(photoPost)) {
            this._photoPosts.push(photoPost);
            return true;
        }
        return false;
    }
    remove(id) {
        for (let i = 0; i < this._photoPosts.length; i++) {
            if (this._photoPosts[i].id == id) {
                this._photoPosts.slice(i, 1);
                return true;
            }
        }
        return false;
    }
    edit(id, changes) {
        var post = this.get(id);
        if (!post)
            return false;
        if (changes.hasOwnProperty('description') && changes.description.length <= 200)
            post.description = changes.description;
        if (changes.hasOwnProperty('hashTags'))
            post.hashTags = changes.hashTags;
        return true;
    }

    static validate(photoPost) {
        for (let i = 0; i < photoPostProperties.length; i++) {
            if (!photoPost.hasOwnProperty(photoPostProperties[i]))
                return false;
        }
        return true;
    }
}

function startTests() {
    const Collection = new PostList(photoPosts);

    console.log(Collection.getPage(0, 10, {
        authors: ['Иванов Иван'],
        hashTags: []
    }));
    console.log(Collection.getPage(0, 10, {
        authors: [],
        fromDate: new Date('2017-01-23T23:00:00'), toDate: new Date('2018-08-23T23:00:00'),
        hashTags: []
    }));
    console.log(Collection.add({
        id: '11',
        description: 'KOKOKO',
        createdAt: new Date('2018-03-19T11:03:00'),
        author: 'Bobr Bobrov',
        hashTags: [],
        photoLink: 'photo2.jpg'
    }));
    console.log(Collection.add({
        id: '12',
        description: 'KOKOKO',
        createdAt: new Date('2018-03-19T11:03:00'),
        author: 'Bobr Bobrov',
        photoLink: 'photo2.jpg'
    }));

    var main = document.getElementById('main');
    Collection.getPage(0, 10, {
        authors: [],
        hashTags: []
    }).forEach(function (post) {
        var article = document.createElement("article");
        var img = document.createElement("img");
        img.src = post.photoLink;
        article.appendChild(img);
        main.appendChild(article);
    });

    console.log(Collection.remove(12));
    console.log(Collection.remove(11));

    console.log(!Collection.get(20));

    console.log(Collection.get(2));
    console.log(Collection.edit(2, {description: 'new description'}))
    console.log(Collection.get(2));
    console.log(Collection.edit(2, {hashTags: '#cool'}))
    console.log(Collection.edit(2, {description: 'new description'}))

}
startTests();