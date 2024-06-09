package DependencyParser;

public class ParserEvaluationScore {

    private double LAS = 0.0;
    private double UAS = 0.0;
    private double LS = 0.0;
    private int wordCount = 0;

    /**
     * Empty constructor of the parser evaluation score object.
     */
    public ParserEvaluationScore(){
    }

    /**
     * Another constructor of the parser evaluation score object.
     * @param LAS Label attachment score
     * @param UAS Unlabelled attachment score
     * @param LS Label score
     * @param wordCount Number of words evaluated
     */
    public ParserEvaluationScore(double LAS, double UAS, double LS, int wordCount){
        this.LAS = LAS;
        this.UAS = UAS;
        this.LS = LS;
        this.wordCount = wordCount;
    }

    /**
     * Accessor for the LS field
     * @return Label score
     */
    public double getLS() {
        return LS;
    }

    /**
     * Accessor for the LAS field
     * @return Label attachment score
     */
    public double getLAS() {
        return LAS;
    }

    /**
     * Accessor for the UAS field
     * @return Unlabelled attachment score
     */
    public double getUAS() {
        return UAS;
    }

    /**
     * Accessor for the word count field
     * @return Number of words evaluated
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * Adds a parser evaluation score to the current evaluation score.
     * @param parserEvaluationScore Parser evaluation score to be added.
     */
    public void add(ParserEvaluationScore parserEvaluationScore){
        LAS = (LAS * wordCount + parserEvaluationScore.LAS * parserEvaluationScore.wordCount) / (wordCount + parserEvaluationScore.wordCount);
        UAS = (UAS * wordCount + parserEvaluationScore.UAS * parserEvaluationScore.wordCount) / (wordCount + parserEvaluationScore.wordCount);
        LS = (LS * wordCount + parserEvaluationScore.LS * parserEvaluationScore.wordCount) / (wordCount + parserEvaluationScore.wordCount);
        wordCount += parserEvaluationScore.wordCount;
    }

}
