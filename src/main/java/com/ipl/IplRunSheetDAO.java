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
    }
    public IplRunSheetDAO(){}
}
