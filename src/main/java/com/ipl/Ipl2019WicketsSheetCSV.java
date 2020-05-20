package com.ipl;

import com.opencsv.bean.CsvBindByName;

public class Ipl2019WicketsSheetCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat")
    public int match;

    @CsvBindByName(column = "Inns")
    public int innings;

    @CsvBindByName(column = "Ov")
    public double overs;

    @CsvBindByName(column = "Runs")
    public int runs;

    @CsvBindByName(column = "Wkts")
    public double wickets;

    @CsvBindByName(column = "Avg")
    public double average;

    @CsvBindByName(column = "Econ")
    public double economy;

    @CsvBindByName(column = "SR")
    public double strikeRate;

    @CsvBindByName(column = "5w")
    public int fiveWickets;

    @CsvBindByName(column = "4w")
    public int fourWickets;

    public Ipl2019WicketsSheetCSV() {
    }

    public Ipl2019WicketsSheetCSV(String player, int match,
                                  int innings, double overs,
                                  int runs, double wickets,
                                  double average, double economy,
                                  double strikeRate, int fiveWickets,
                                  int fourWickets) {
        this.player = player;
        this.match = match;
        this.innings = innings;
        this.overs = overs;
        this.runs = runs;
        this.wickets = wickets;
        this.average = average;
        this.economy = economy;
        this.strikeRate = strikeRate;
        this.fiveWickets = fiveWickets;
        this.fourWickets = fourWickets;
    }

    @Override
    public String toString() {
        return "Ipl2019WicketsSheetCSV{" +
                "player='" + player + '\'' +
                ", match=" + match +
                ", innings=" + innings +
                ", overs=" + overs +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", average=" + average +
                ", economy=" + economy +
                ", strikeRate=" + strikeRate +
                ", fiveWickets=" + fiveWickets +
                ", fourWickets=" + fourWickets +
                '}';
    }
}