package DependencyParser;

public class ParserEvaluationScore {

    private double LAS = 0.0;
    private double UAS = 0.0;
    private double LS = 0.0;
    private int wordCount = 0;

    public ParserEvaluationScore(){
    }

    public ParserEvaluationScore(double LAS, double UAS, double LS, int wordCount){
        this.LAS = LAS;
        this.UAS = UAS;
        this.LS = LS;
        this.wordCount = wordCount;
    }

    public double getLS() {
        return LS;
    }

    public double getLAS() {
        return LAS;
    }

    public double getUAS() {
        return UAS;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void add(ParserEvaluationScore parserEvaluationScore){
        LAS = (LAS * wordCount + parserEvaluationScore.LAS * parserEvaluationScore.wordCount) / (wordCount + parserEvaluationScore.wordCount);
        UAS = (UAS * wordCount + parserEvaluationScore.UAS * parserEvaluationScore.wordCount) / (wordCount + parserEvaluationScore.wordCount);
        LS = (LS * wordCount + parserEvaluationScore.LS * parserEvaluationScore.wordCount) / (wordCount + parserEvaluationScore.wordCount);
        wordCount += parserEvaluationScore.wordCount;
    }

}
