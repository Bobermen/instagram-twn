USE gram_db;
SELECT USER.USER_ID,
       USER.NAME,
       SUM(MONTH(PHOTO_POST.CREATION_DATE) = 5 AND DAYOFMONTH(PHOTO_POST.CREATION_DATE) = 9)
         AS POST_COUNT_9_MAY
FROM PHOTO_POST
       JOIN USER ON USER.USER_ID = PHOTO_POST.USER_ID
GROUP BY PHOTO_POST.USER_ID;