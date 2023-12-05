SELECT
    category,
    SUM(CASE WHEN classId = 'a' AND grade > 80 THEN 1 ELSE 0 END) AS classA_over_80,
    SUM(CASE WHEN classId = 'b' AND grade BETWEEN 60 AND 79 THEN 1 ELSE 0 END) AS classB_60_to_79,
    SUM(CASE WHEN classId = 'c' AND grade BETWEEN 0 AND 59 THEN 1 ELSE 0 END) AS classC_0_to_59,
    AVG(CASE WHEN classId = 'a' AND grade > 80 THEN grade ELSE NULL END) AS classA_avg_over_80,
    AVG(CASE WHEN classId = 'b' and grade BETWEEN 60 AND 79 THEN 1 ELSE 0 END) AS classB_avg_60_to_79,
    AVG(CASE WHEN classId = 'c' and grade BETWEEN 0 AND 59 THEN 1 ELSE 0 END) AS classC_avg_0_to_59
FROM
    grades  -- Replace with your actual table name
GROUP BY
    category;