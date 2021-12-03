SELECT
    Weather.id AS 'Id'
FROM
    Weather
        join
    Weather w ON datediff(Weather.recordDate, w.recordDate) = 1
        AND Weather.Temperature > w.Temperature
;