package bai8_clean_code_refactoring.bai_tap;

public class TennisGame {
    public static String equalScores(int markScorePlayer1) {
        switch (markScorePlayer1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public static String scoreOver4(int minusResult) {
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    public static String scoreUnder4(int markScorePlayer1, int markScorePlayer2) {
        int tempScore = 0;
        StringBuilder resultScore = new StringBuilder();
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = markScorePlayer1;
            } else {
                resultScore.append("-");
                tempScore = markScorePlayer2;
            }
            switch (tempScore) {
                case 0:
                    resultScore.append("Love");
                    break;
                case 1:
                    resultScore.append("Fifteen");
                    break;
                case 2:
                    resultScore.append("Thirty");
                    break;
                case 3:
                    resultScore.append("Forty");
                    break;
            }
        }
        return resultScore.toString();
    }

    public static String getScore(String player1Name, String player2Name, int markScorePlayer1, int markScorePlayer2) {
        String score = "";
        if (markScorePlayer1 == markScorePlayer2) {
            score = equalScores(markScorePlayer1);
        } else if (markScorePlayer1 >= 4 || markScorePlayer2 >= 4) {
            int minusResult = markScorePlayer1 - markScorePlayer2;
            score = scoreOver4(minusResult);
        } else {
            score = scoreUnder4(markScorePlayer1, markScorePlayer2);
        }
        return score;
    }
}
