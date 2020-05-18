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
    }
    public IplRunSheetDAO(){}
}
