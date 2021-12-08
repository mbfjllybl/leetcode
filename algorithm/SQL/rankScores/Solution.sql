SELECT
    Score, (SELECT COUNT(DISTINCT Score) FROM Scores WHERE Score >= S.Score) AS 'Rank'
FROM
    Scores AS S
ORDER BY
    S.Score DESC
;