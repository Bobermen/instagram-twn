USE gram_db;
SELECT * FROM PHOTO_POST
WHERE PHOTO_POST.USER_ID = 1 AND LOCATE("hello", PHOTO_POST.DESCRIPTION);