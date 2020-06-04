package com.ipl;

import com.opencsv.bean.CsvBindByName;

public class IplBatsmenSheetCSV {
    @CsvBindByName(column ="PLAYER" , required=true)
    public String player;

    @CsvBindByName(column ="NO")
    public int notOut;

    @CsvBindByName(column ="Runs" , required=true)
    public int runs;

    @CsvBindByName(column ="SR" )
    public double batsmenStrikeRate;

    @CsvBindByName(column ="Avg" )
    public double batsmenAverage;

    @CsvBindByName(column ="6s" , required=true)
    public int sixes;

    @CsvBindByName(column ="4s" , required=true)
    public int fours;

    public IplBatsmenSheetCSV() {
    }

    public IplBatsmenSheetCSV(String player, int notOut, int runs, double batsmenStrikeRate,
                              double batsmenAverage, int sixes, int fours) {
        this.player = player;
        this.notOut = notOut;
        this.runs = runs;
        this.batsmenStrikeRate = batsmenStrikeRate;
        this.batsmenAverage = batsmenAverage;
        this.sixes = sixes;
        this.fours = fours;
    }

    @Override
    public String toString() {
        return "Ipl2019RunsSheet{" +
                "player='" + player + '\'' +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", strikeRate=" + batsmenStrikeRate +
                ", average=" + batsmenAverage +
                ", sixes=" + sixes +
                ", fours=" + fours +
                '}';
    }
}
