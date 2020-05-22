package com.ipl;

public class IplSheetDAO {
    public String player;
    public int match;
    public int innings;
    public int notOut;
    public int runs;
    public double strikeRate;
    public double average;
    public double bowlingAverage;
    public int sixes;
    public int fours;
    public double combinationOfFoursAndSixes;
    public double combinationOfFoursSixesAndStriteRate;
    public double combinationOfStrikeRateAndAverage;
    public double combinationOfRunsWithAverage;
    public double overs;
    public double wickets;
    public double economy;
    public int fiveWickets;
    public int fourWickets;
    public double combinationOfStrikeRateWith4And5Wickets;
    public double combinationOfBowlingStrikeRateWithAverage;
    public double combinationOfMaxWicketsWithBowlingAverage;
    public double bestBowlingAndBattingAverages;
    public double bestWicketsAndRuns;

    public IplSheetDAO(Ipl2019BowlersSheetCSV iplBolwersCSV) {
        this.player = iplBolwersCSV.player;
        this.match = iplBolwersCSV.match;
        this.innings = iplBolwersCSV.innings;
        this.runs = iplBolwersCSV.runs;
        this.strikeRate = iplBolwersCSV.strikeRate;
        this.bowlingAverage = iplBolwersCSV.bowlingAverage;
        this.overs = iplBolwersCSV.overs;
        this.wickets = iplBolwersCSV.wickets;
        this.economy = iplBolwersCSV.economy;
        this.fiveWickets = iplBolwersCSV.fiveWickets;
        this.fourWickets = iplBolwersCSV.fourWickets;
        this.combinationOfStrikeRateWith4And5Wickets=
                ( iplBolwersCSV.fourWickets+ iplBolwersCSV.fiveWickets*iplBolwersCSV.strikeRate);
        this.combinationOfBowlingStrikeRateWithAverage= iplBolwersCSV.overs*
                iplBolwersCSV.wickets* iplBolwersCSV.bowlingAverage * iplBolwersCSV.runs;
        this.combinationOfMaxWicketsWithBowlingAverage= iplBolwersCSV.wickets
                * iplBolwersCSV.overs* iplBolwersCSV.bowlingAverage;

        this.bestWicketsAndRuns=iplBolwersCSV.wickets*this.runs;
    }

    public IplSheetDAO(Ipl2019BatsmenSheetCSV iplBatsmenSheetCSV) {
        this.player = iplBatsmenSheetCSV.player;
        this.match = iplBatsmenSheetCSV.match;
        this.innings = iplBatsmenSheetCSV.innings;
        this.notOut = iplBatsmenSheetCSV.notOut;
        this.runs = iplBatsmenSheetCSV.runs;
        this.strikeRate = iplBatsmenSheetCSV.strikeRate;
        this.average = iplBatsmenSheetCSV.average;
        this.sixes = iplBatsmenSheetCSV.sixes;
        this.fours = iplBatsmenSheetCSV.fours;
        this.combinationOfFoursAndSixes= (iplBatsmenSheetCSV.fours*4)+(iplBatsmenSheetCSV.sixes*6);
        this.combinationOfFoursSixesAndStriteRate= iplBatsmenSheetCSV.fours* iplBatsmenSheetCSV.sixes* iplBatsmenSheetCSV.strikeRate;
        this.combinationOfStrikeRateAndAverage= iplBatsmenSheetCSV.runs* iplBatsmenSheetCSV.strikeRate* iplBatsmenSheetCSV.average* iplBatsmenSheetCSV.notOut;
        this.combinationOfRunsWithAverage= iplBatsmenSheetCSV.runs* iplBatsmenSheetCSV.average;
        this.bestBowlingAndBattingAverages=this.average*this.bowlingAverage*
                this.wickets*this.runs;
    }

    public IplSheetDAO(){}

}
