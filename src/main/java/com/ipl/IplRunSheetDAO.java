package com.ipl;

public class IplRunSheetDAO {
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

    public IplRunSheetDAO(Ipl2019WicketsSheetCSV iplWicketsSheetCSV) {
        this.player = iplWicketsSheetCSV.player;
        this.match = iplWicketsSheetCSV.match;
        this.innings = iplWicketsSheetCSV.innings;
        this.runs = iplWicketsSheetCSV.runs;
        this.strikeRate = iplWicketsSheetCSV.strikeRate;
        this.average = iplWicketsSheetCSV.average;
        this.overs = iplWicketsSheetCSV.overs;
        this.wickets = iplWicketsSheetCSV.wickets;
        this.economy = iplWicketsSheetCSV.economy;
        this.fiveWickets = iplWicketsSheetCSV.fiveWickets;
        this.fourWickets = iplWicketsSheetCSV.fourWickets;
    }

    public IplRunSheetDAO(Ipl2019RunsSheetCSV iplRunsSheetCSV) {
        this.player = iplRunsSheetCSV.player;
        this.match = iplRunsSheetCSV.match;
        this.innings = iplRunsSheetCSV.innings;
        this.notOut = iplRunsSheetCSV.notOut;
        this.runs = iplRunsSheetCSV.runs;
        this.strikeRate = iplRunsSheetCSV.strikeRate;
        this.average = iplRunsSheetCSV.average;
        this.hundreds = iplRunsSheetCSV.hundreds;
        this.fiftys = iplRunsSheetCSV.fiftys;
        this.sixes = iplRunsSheetCSV.sixes;
        this.fours = iplRunsSheetCSV.fours;
        this.combinationOfFoursAndSixes=iplRunsSheetCSV.fours*iplRunsSheetCSV.sixes;
        this.combinationOfFoursSixesAndStriteRate=iplRunsSheetCSV.fours*iplRunsSheetCSV.sixes*iplRunsSheetCSV.strikeRate;
        this.combinationOfStrikeRateAndAverage=iplRunsSheetCSV.runs*iplRunsSheetCSV.strikeRate*iplRunsSheetCSV.average*iplRunsSheetCSV.notOut;
        this.combinationOfRunsWithAverage= iplRunsSheetCSV.runs*iplRunsSheetCSV.average;
    }

    public IplRunSheetDAO(){}

}
