package com.ipl;

public class IplSheetDAO {
    public String player;
    public int match;
    public int innings;
    public int notOut;
    public int runs;
    public double strikeRate;
    public double average;
    public int hundreds;
    public int fiftys;
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
    public double bowlingAverage;

    public IplSheetDAO(Ipl2019BowlersSheetCSV iplBolwerstCSV) {
        this.player = iplBolwerstCSV.player;
        this.match = iplBolwerstCSV.match;
        this.innings = iplBolwerstCSV.innings;
        this.runs = iplBolwerstCSV.runs;
        this.strikeRate = iplBolwerstCSV.strikeRate;
        this.average = iplBolwerstCSV.bowlingAverage;
        this.overs = iplBolwerstCSV.overs;
        this.wickets = iplBolwerstCSV.wickets;
        this.economy = iplBolwerstCSV.economy;
        this.fiveWickets = iplBolwerstCSV.fiveWickets;
        this.fourWickets = iplBolwerstCSV.fourWickets;
        this.combinationOfStrikeRateWith4And5Wickets= iplBolwerstCSV.overs*
                (iplBolwerstCSV.wickets+ iplBolwerstCSV.fourWickets+ iplBolwerstCSV.fiveWickets);
        this.combinationOfBowlingStrikeRateWithAverage= iplBolwerstCSV.overs*
                iplBolwerstCSV.wickets* iplBolwerstCSV.bowlingAverage * iplBolwerstCSV.runs;
        this.combinationOfMaxWicketsWithBowlingAverage= iplBolwerstCSV.wickets
                * iplBolwerstCSV.overs* iplBolwerstCSV.bowlingAverage;

    }

    public IplSheetDAO(Ipl2019BatsmenSheetCSV iplBatsmenSheetCSV) {
        this.player = iplBatsmenSheetCSV.player;
        this.match = iplBatsmenSheetCSV.match;
        this.innings = iplBatsmenSheetCSV.innings;
        this.notOut = iplBatsmenSheetCSV.notOut;
        this.runs = iplBatsmenSheetCSV.runs;
        this.strikeRate = iplBatsmenSheetCSV.strikeRate;
        this.average = iplBatsmenSheetCSV.average;
        this.hundreds = iplBatsmenSheetCSV.hundreds;
        this.fiftys = iplBatsmenSheetCSV.fiftys;
        this.sixes = iplBatsmenSheetCSV.sixes;
        this.fours = iplBatsmenSheetCSV.fours;
        this.combinationOfFoursAndSixes= iplBatsmenSheetCSV.fours* iplBatsmenSheetCSV.sixes;
        this.combinationOfFoursSixesAndStriteRate= iplBatsmenSheetCSV.fours* iplBatsmenSheetCSV.sixes* iplBatsmenSheetCSV.strikeRate;
        this.combinationOfStrikeRateAndAverage= iplBatsmenSheetCSV.runs* iplBatsmenSheetCSV.strikeRate* iplBatsmenSheetCSV.average* iplBatsmenSheetCSV.notOut;
        this.combinationOfRunsWithAverage= iplBatsmenSheetCSV.runs* iplBatsmenSheetCSV.average;
    }

    public IplSheetDAO(){}

}
