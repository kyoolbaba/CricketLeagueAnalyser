package com.ipl;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
public class CricketLeagueAnalyserTest {
    public static final String IPL_2019_FACT_SHEET_MOSTRUNS="C:\\Users\\KYOOLBABAA\\Desktop\\New folder\\IPL2019FactsheetMostRuns.csv";
    public static final String INCOMPATIBLE_FILE_PATH="C:\\Users\\KYOOLBABAA\\Desktop\\New folder\\SCode.csv";
    public static final String INVALID_FILE_PATH="abc.txt";
    public static final String IPL_2019_FACT_SHEET_MOSTWICKETS="C:\\Users\\KYOOLBABAA\\Desktop\\New folder\\IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIpl2019RunsCSVFile_ShouldReturnCorrectRecord() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
        int count=cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        Assert.assertEquals(100,count);
    }

    @Test
    public void givenWrongFilePath_ShouldReturnIOException() {
       try {
           CricketLeagueAnalyser cricketLeagueAnalyser =
                   new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
           int count = cricketLeagueAnalyser.loadRunsSheetData(INVALID_FILE_PATH);
       }catch(CricketLeagueAnalyserException e){
           Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.FILE_NOT_PRESENT,e.type);
       }
    }

    @Test
    public void givenWrongCsvFile_ShouldThroughRunTimeException() throws CricketLeagueAnalyserException {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser =
                    new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(INCOMPATIBLE_FILE_PATH);
        }catch(CricketLeagueAnalyserException e){
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.DATA_NOT_APPROPRIATE,e.type);
        }
    }

    @Test
    public void givenIpl2019BatsmenCSVFile_ShouldReturnAverageOfRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedAverageData=cricketLeagueAnalyser.getAverageWiseSortedData();
        Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedAverageData, Ipl2019BatsmenSheetCSV[].class);
        Assert.assertEquals("MS Dhoni",sortedData[sortedData.length-1].player);
        Assert.assertEquals("Ishant Sharma",sortedData[0].player);
    }

    @Test
    public void givenIpl2019BatsmenCSVFile_ShouldReturnMinAverageOfRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedAverageData=cricketLeagueAnalyser.getAverageWiseSortedData();
        Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedAverageData, Ipl2019BatsmenSheetCSV[].class);
        Assert.assertEquals("Ishant Sharma",sortedData[0].player);
    }

    @Test
    public void givenIpl2019BatsmenCSVFile_ShouldReturnMaxStrikingRateInRecords() throws CricketLeagueAnalyserException {
    CricketLeagueAnalyser cricketLeagueAnalyser= 
            new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
    cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
    String sortedStrikeRateData=cricketLeagueAnalyser.getStrikeRateWiseSortedData();
        Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedStrikeRateData, Ipl2019BatsmenSheetCSV[].class);
    Assert.assertEquals("Ishant Sharma",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenIpl2019BatsmenCSVFile_ShouldReturnMaximunSixesInRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedStrikeRateData=cricketLeagueAnalyser.getSixesWiseSortedData();
        Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedStrikeRateData, Ipl2019BatsmenSheetCSV[].class);
        Assert.assertEquals("Andre Russell",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenIpl2019BatsmenCSVFile_ShouldReturnMinimunSixesInRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedDataByFourAndSixes=cricketLeagueAnalyser.getSixesWiseSortedData();
        Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedDataByFourAndSixes, Ipl2019BatsmenSheetCSV[].class);
        Assert.assertEquals("Kuldeep Yadav",sortedData[0].player);
    }

    @Test
    public void givenIpl2019BatsmenCSVFile_ShouldReturnPlayerOfBestCombinationsOfSixesAndFoursInRecord() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedDataBySixesAnfFours=cricketLeagueAnalyser.getSixesAndFoursWiseSortedData();
        Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedDataBySixesAnfFours, Ipl2019BatsmenSheetCSV[].class);
        Assert.assertEquals("Andre Russell",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenIpl2019BatsmenCSVFile_ShouldReturnMaximunFoursInRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedData=cricketLeagueAnalyser.getFoursWiseSortedData();
        Ipl2019BatsmenSheetCSV[] sortedStrikeRateData=new Gson().fromJson(sortedData, Ipl2019BatsmenSheetCSV[].class);
        Assert.assertEquals("Tim Southee",sortedStrikeRateData[0].player);
    }

    @Test
    public void givenIpl2019BatsmenCSVFile_ShouldReturnMinimunFoursInRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedData=cricketLeagueAnalyser.getFoursWiseSortedData();
        Ipl2019BatsmenSheetCSV[] sortedStrikeRateData=new Gson().fromJson(sortedData, Ipl2019BatsmenSheetCSV[].class);
        Assert.assertEquals("Shikhar Dhawan",sortedStrikeRateData[sortedStrikeRateData.length-1].player);
    }

    @Test
    public void givenIpl2019BatsmenCSVFile_ShouldReturnPlayerOfBestCombinationsOfSixesFoursAndStrikeRate() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedData=cricketLeagueAnalyser.getStrikeRateWiseWithSixesAndFoursSortedData();
        Ipl2019BatsmenSheetCSV[] sortedStrikeRateData=new Gson().fromJson(sortedData, Ipl2019BatsmenSheetCSV[].class);
        Assert.assertEquals("Andre Russell",sortedStrikeRateData[sortedStrikeRateData.length-1].player);
    }

    @Test
    public void givenIpl2019BatsmenCSVFile_ShouldReturnPlayerOfBestCombinationOfAverageAndStrikeRate() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedData=cricketLeagueAnalyser.getBestCombinationOfAverageAndStrikeRate();
        Ipl2019BatsmenSheetCSV[] sortedCombinationOfStrikeRateAndAverage=new Gson().fromJson(sortedData, Ipl2019BatsmenSheetCSV[].class);
        Assert.assertEquals("MS Dhoni",sortedCombinationOfStrikeRateAndAverage[sortedCombinationOfStrikeRateAndAverage.length-1].player);
    }

    @Test
    public void givenIpl2019BatsmenCSVFile_ShouldReturnPlayerOfBestCombinationOfMaxRunsWithAverages() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
        String sortedCombinationOfRunsAndAverage=cricketLeagueAnalyser.getBestCombinationRunsAndAverage();
        Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedCombinationOfRunsAndAverage, Ipl2019BatsmenSheetCSV[].class);
        Assert.assertEquals("David Warner ",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenIpl2019BowlersCSVFile_ShouldReturnCorrectRecord() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
        int noOfRecords=cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
        Assert.assertEquals(99,noOfRecords);

    }

    @Test
    public void givenIpl2019BowlersCSVFile_ShouldReturnTopBowlingAverage() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
        String sortedDataByBowlingAverage=cricketLeagueAnalyser.getBowlingAverage();
        Ipl2019BowlersSheetCSV[] sortedData=new Gson().fromJson(sortedDataByBowlingAverage, Ipl2019BowlersSheetCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenIpl2019BowlersCSVFile_ShouldReturnTopStrikeRate() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
        String sortedDataByStrikeRate=cricketLeagueAnalyser.getStrikeRateWiseSortedData();
        Ipl2019BowlersSheetCSV[] sortedData=new Gson().fromJson(sortedDataByStrikeRate, Ipl2019BowlersSheetCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenIpl2019BowlersCSVFile_ShouldReturnBestEconomy() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
        String sortedDataByEconomy=cricketLeagueAnalyser.getEconomyWiseSortedData();
        IplSheetDAO[] sortedData=new Gson().fromJson(sortedDataByEconomy, IplSheetDAO[].class);
        Assert.assertEquals("Ben Cutting",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenIpl2019BowlersCSVFile_ShouldReturnBestStrikeRateWith4And5Wickets() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
        String BestOfStrikeRateWith4And5Wickets=cricketLeagueAnalyser.getBestOfStrikeRateWith4And5Wickets();
        IplSheetDAO[] sortedData=new Gson().fromJson(BestOfStrikeRateWith4And5Wickets, IplSheetDAO[].class);
        Assert.assertEquals("Imran Tahir",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenIpl2019BowlersCSVFile_ShouldReturnBestBowlingStrikeRateWithAverage() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
        String sortedDataByBestOfBowlingStrikeRateWithAverage=cricketLeagueAnalyser.getBestOfBowlingStrikeRateWithAverage();
        IplSheetDAO[] sortedData=new Gson().fromJson(sortedDataByBestOfBowlingStrikeRateWithAverage, IplSheetDAO[].class);
        Assert.assertEquals("Deepak Chahar",sortedData[sortedData.length-1].player);

    }

    @Test
    public void givenIpl2019BowBatsmenCSVFile_ShouldReturnMaxWicketsWithBestAverage() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
        String sortedDataByBestOfBowlingStrikeRateWithAverage=cricketLeagueAnalyser.getMaxWicketsWithBestBowlingAverage();
        IplSheetDAO[] sortedData=new Gson().fromJson(sortedDataByBestOfBowlingStrikeRateWithAverage, IplSheetDAO[].class);
        Assert.assertEquals("Deepak Chahar",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenIpl2019BowlersAndBatsmenCSVFile_ShouldReturnBCorrectRecords() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
       int noOfRecords= cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS,IPL_2019_FACT_SHEET_MOSTWICKETS);
        Assert.assertEquals(100,noOfRecords);
    }

    @Test
    public void givenIpl2019BowlersAndBatsmenCSVFile_ShouldReturnBestBattingAndBowlingAverages() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS,IPL_2019_FACT_SHEET_MOSTWICKETS);
        String sortedDataBestBowlingAndBattingAverage=cricketLeagueAnalyser.getBestBowlingAndBattingAverage();
        IplSheetDAO[] sortedData=new Gson().fromJson(sortedDataBestBowlingAndBattingAverage, IplSheetDAO[].class);
        Assert.assertEquals("Shreyas Iyer",sortedData[sortedData.length-1].player);
    }

    @Test
    public void givenIpl2019BowlersAndBatsmenCSVFile_ShouldReturnPlayersWIthMaxmunRunsAndWicket() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS,IPL_2019_FACT_SHEET_MOSTWICKETS);
        String sortedDataBestRunsAndWickets=cricketLeagueAnalyser.getBestRunsAndWickets();
        IplSheetDAO[] sortedData=new Gson().fromJson(sortedDataBestRunsAndWickets, IplSheetDAO[].class);
        Assert.assertEquals("Shreyas Iyer",sortedData[sortedData.length-1].player);
    }
}
