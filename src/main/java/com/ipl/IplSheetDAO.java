package com.ipl;

public class IplSheetDAO {
    public String player;
    public int notOut;
    public int runs;
    public double strikeRate;
    public double batsmenAverage;
    public double bowlingAverage;
    public int sixes;
    public int fours;
    public double combinationOfFoursAndSixes;
    public double combinationOfFoursSixesAndStriteRate;
    public double combinationOfStrikeRateAndAverage;
    public double combinationOfRunsWithAverage;
    public double overs;
    public int wickets;
    public double economy;
    public int fiveWickets;
    public int fourWickets;
    public double combinationOfStrikeRateWith4And5Wickets;
    public double combinationOfBowlingStrikeRateWithAverage;
    public double combinationOfMaxWicketsWithBowlingAverage;
    public double bestBowlingAndBattingAverages;
    public double bestWicketsAndRuns;

    public IplSheetDAO(IplBowlersSheetCSV iplBolwersCSV) {
        this.player = iplBolwersCSV.player;
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

    public IplSheetDAO(IplBatsmenSheetCSV iplBatsmenSheetCSV) {
        this.player = iplBatsmenSheetCSV.player;
        this.notOut = iplBatsmenSheetCSV.notOut;
        this.runs = iplBatsmenSheetCSV.runs;
        this.strikeRate = iplBatsmenSheetCSV.batsmenStrikeRate;
        this.batsmenAverage = iplBatsmenSheetCSV.batsmenAverage;
        this.sixes = iplBatsmenSheetCSV.sixes;
        this.fours = iplBatsmenSheetCSV.fours;
        this.combinationOfFoursAndSixes= (iplBatsmenSheetCSV.fours*4)+(iplBatsmenSheetCSV.sixes*6);
        this.combinationOfFoursSixesAndStriteRate= iplBatsmenSheetCSV.fours* iplBatsmenSheetCSV.sixes* iplBatsmenSheetCSV.batsmenStrikeRate;
        this.combinationOfStrikeRateAndAverage= iplBatsmenSheetCSV.runs* iplBatsmenSheetCSV.batsmenStrikeRate * iplBatsmenSheetCSV.batsmenAverage * iplBatsmenSheetCSV.notOut;
        this.combinationOfRunsWithAverage= iplBatsmenSheetCSV.runs* iplBatsmenSheetCSV.batsmenAverage;
        this.bestBowlingAndBattingAverages=this.batsmenAverage *this.bowlingAverage*
                this.wickets*this.runs;
    }

    public IplSheetDAO(){}

}
