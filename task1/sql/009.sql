USE gram_db;
SELECT USER.NAME, PHOTO_POST.CREATION_DATE
FROM PHOTO_POST
       JOIN USER ON USER.USER_ID = PHOTO_POST.USER_ID
WHERE LENGTH(PHOTO_POST.DESCRIPTION) > 10;