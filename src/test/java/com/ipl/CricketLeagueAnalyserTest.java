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
    public void givenIplRunsCSVFile_ShouldReturnCorrectRecord()  {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            int count=cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
            Assert.assertEquals(100,count);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
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
    public void givenWrongCsvFile_ShouldThroughRunTimeException()  {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser =
                    new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(INCOMPATIBLE_FILE_PATH);
        }catch(CricketLeagueAnalyserException e){
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.DATA_NOT_APPROPRIATE,e.type);
        }
    }

    @Test
    public void givenIplBatsmenCSVFile_whenSorted_shouldReturnAverageOfRecords() {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
            String sortedAverageData=cricketLeagueAnalyser.getAverageWiseSortedData();
            Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedAverageData, Ipl2019BatsmenSheetCSV[].class);
            Assert.assertEquals("MS Dhoni",sortedData[sortedData.length-1].player);
            Assert.assertEquals("Ishant Sharma",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBatsmenCSVFile_whenSorted_shouldReturnMinAverageOfRecords() {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
            String sortedAverageData=cricketLeagueAnalyser.getAverageWiseSortedData();
            Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedAverageData, Ipl2019BatsmenSheetCSV[].class);
            Assert.assertEquals("Ishant Sharma",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBatsmenCSVFile_whenSorted_shouldReturnMaxStrikingRateInRecords() {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
             cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
            String sortedStrikeRateData=cricketLeagueAnalyser.getStrikeRateWiseSortedData();
            Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedStrikeRateData, Ipl2019BatsmenSheetCSV[].class);
        Assert.assertEquals("Ishant Sharma",sortedData[sortedData.length-1].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBatsmenCSVFile_whenSorted_shouldReturnMaximunSixesInRecords() {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
            String sortedStrikeRateData=cricketLeagueAnalyser.getSixesWiseSortedData();
            Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedStrikeRateData, Ipl2019BatsmenSheetCSV[].class);
            Assert.assertEquals("Andre Russell",sortedData[sortedData.length-1].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBatsmenCSVFile_whenSorted_shouldReturnMinimunSixesInRecords(){
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
            String sortedDataByFourAndSixes=cricketLeagueAnalyser.getSixesWiseSortedData();
            Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedDataByFourAndSixes, Ipl2019BatsmenSheetCSV[].class);
            Assert.assertEquals("Kuldeep Yadav",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBatsmenCSVFile_whenSorted_shouldReturnPlayerOfBestCombinationsOfSixesAndFoursInRecord()  {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
            String sortedDataBySixesAnfFours=cricketLeagueAnalyser.getSixesAndFoursWiseSortedData();
            Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedDataBySixesAnfFours, Ipl2019BatsmenSheetCSV[].class);
            Assert.assertEquals("Andre Russell",sortedData[sortedData.length-1].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBatsmenCSVFile_whenSorted_shouldReturnMaximunFoursInRecords() throws CricketLeagueAnalyserException {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
            String sortedData=cricketLeagueAnalyser.getFoursWiseSortedData();
            Ipl2019BatsmenSheetCSV[] sortedStrikeRateData=new Gson().fromJson(sortedData, Ipl2019BatsmenSheetCSV[].class);
            Assert.assertEquals("Tim Southee",sortedStrikeRateData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBatsmenCSVFile_whenSorted_shouldReturnMinimunFoursInRecords()  {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
            String sortedStrikeRateData=cricketLeagueAnalyser.getFoursWiseSortedData();
            Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedStrikeRateData, Ipl2019BatsmenSheetCSV[].class);
            Assert.assertEquals("Shikhar Dhawan",sortedData[sortedData.length-1].player);
            Assert.assertEquals("Tim Southee",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBatsmenCSVFile_whenSorted_shouldReturnPlayerOfBestCombinationsOfSixesFoursAndStrikeRate() {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
            String sortedStrikeRateData=cricketLeagueAnalyser.getStrikeRateWiseWithSixesAndFoursSortedData();
            Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedStrikeRateData, Ipl2019BatsmenSheetCSV[].class);
            Assert.assertEquals("Andre Russell",sortedData[sortedData.length-1].player);
            Assert.assertEquals("Kuldeep Yadav",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
        e.printStackTrace();
        }
    }

    @Test
    public void givenIplBatsmenCSVFile_whenSorted_shouldReturnPlayerOfBestCombinationOfAverageAndStrikeRate()  {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
            String sortedCombinationOfStrikeRateAndAverage=cricketLeagueAnalyser.getBestCombinationOfAverageAndStrikeRate();
            Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedCombinationOfStrikeRateAndAverage, Ipl2019BatsmenSheetCSV[].class);
            Assert.assertEquals("MS Dhoni",sortedData[sortedData.length-1].player);
            Assert.assertEquals("Shimron Hetmyer",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBatsmenCSVFile_whenSorted_shouldReturnPlayerOfBestCombinationOfMaxRunsWithAverages()  {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.RUNSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS);
            String sortedCombinationOfRunsAndAverage=cricketLeagueAnalyser.getBestCombinationRunsAndAverage();
            Ipl2019BatsmenSheetCSV[] sortedData=new Gson().fromJson(sortedCombinationOfRunsAndAverage, Ipl2019BatsmenSheetCSV[].class);
            Assert.assertEquals("David Warner ",sortedData[sortedData.length-1].player);
            Assert.assertEquals("Ishant Sharma",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBowlersCSVFile_whenSorted_shouldReturnCorrectRecord()  {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
            int noOfRecords=cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
            Assert.assertEquals(99,noOfRecords);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBowlersCSVFile_whenSorted_shouldReturnTopBowlingAverage() throws CricketLeagueAnalyserException {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
            String sortedDataByBowlingAverage=cricketLeagueAnalyser.getBowlingAverage();
            Ipl2019BowlersSheetCSV[] sortedData=new Gson().fromJson(sortedDataByBowlingAverage, Ipl2019BowlersSheetCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham",sortedData[sortedData.length-1].player);
            Assert.assertEquals("Suresh Raina",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBowlersCSVFile_whenSorted_shouldReturnTopStrikeRate() throws CricketLeagueAnalyserException {
       try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
            String sortedDataByStrikeRate=cricketLeagueAnalyser.getStrikeRateWiseSortedData();
            Ipl2019BowlersSheetCSV[] sortedData=new Gson().fromJson(sortedDataByStrikeRate, Ipl2019BowlersSheetCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham",sortedData[sortedData.length-1].player);
            Assert.assertEquals("Suresh Raina",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBowlersCSVFile_whenSorted_shouldReturnBestEconomy() throws CricketLeagueAnalyserException {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
            String sortedDataByEconomy=cricketLeagueAnalyser.getEconomyWiseSortedData();
            IplSheetDAO[] sortedData=new Gson().fromJson(sortedDataByEconomy, IplSheetDAO[].class);
            Assert.assertEquals("Ben Cutting",sortedData[sortedData.length-1].player);
            Assert.assertEquals("Shivam Dube",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIp9BowlersCSVFile_whenSorted_shouldReturnBestStrikeRateWith4And5Wickets()  {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser =
                    new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
            String BestOfStrikeRateWith4And5Wickets = cricketLeagueAnalyser.getBestOfStrikeRateWith4And5Wickets();
            IplSheetDAO[] sortedData = new Gson().fromJson(BestOfStrikeRateWith4And5Wickets, IplSheetDAO[].class);
            Assert.assertEquals("Imran Tahir", sortedData[sortedData.length - 1].player);
            Assert.assertEquals("Suresh Raina", sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBowlersCSVFile_whenSorted_shouldReturnBestBowlingStrikeRateWithAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser =
                    new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
            String sortedDataByBestOfBowlingStrikeRateWithAverage = cricketLeagueAnalyser.getBestOfBowlingStrikeRateWithAverage();
            IplSheetDAO[] sortedData = new Gson().fromJson(sortedDataByBestOfBowlingStrikeRateWithAverage, IplSheetDAO[].class);
            Assert.assertEquals("Deepak Chahar", sortedData[sortedData.length - 1].player);
            Assert.assertEquals("Suresh Raina", sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBowBatsmenCSVFile_whenSorted_shouldReturnMaxWicketsWithBestAverage()  {
        try{
        CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
        cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTWICKETS);
        String sortedDataByBestOfBowlingStrikeRateWithAverage=cricketLeagueAnalyser.getMaxWicketsWithBestBowlingAverage();
        IplSheetDAO[] sortedData=new Gson().fromJson(sortedDataByBestOfBowlingStrikeRateWithAverage, IplSheetDAO[].class);
        Assert.assertEquals("Deepak Chahar",sortedData[sortedData.length-1].player);
        Assert.assertEquals("Suresh Raina",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }

    }

    @Test
    public void givenIplBowlersAndBatsmenCSVFile_whenSorted_shouldReturnBCorrectRecords(){
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
            int noOfRecords= cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS,IPL_2019_FACT_SHEET_MOSTWICKETS);
            Assert.assertEquals(100,noOfRecords);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBowlersAndBatsmenCSVFile_whenSorted_shouldReturnBestBattingAndBowlingAverages()  {
        try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS,IPL_2019_FACT_SHEET_MOSTWICKETS);
            String sortedDataBestBowlingAndBattingAverage=cricketLeagueAnalyser.getBestBowlingAndBattingAverage();
            IplSheetDAO[] sortedData=new Gson().fromJson(sortedDataBestBowlingAndBattingAverage, IplSheetDAO[].class);
            Assert.assertEquals("Shreyas Iyer",sortedData[sortedData.length-1].player);
            Assert.assertEquals("Marcus Stoinis",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBowlersAndBatsmenCSVFile_whenSorted_shouldReturnPlayersWIthMaxmunRunsAndWicket() {
       try{
            CricketLeagueAnalyser cricketLeagueAnalyser=
                new CricketLeagueAnalyser(CricketLeagueAnalyser.IplSheet.WICKETSHEET);
            cricketLeagueAnalyser.loadRunsSheetData(IPL_2019_FACT_SHEET_MOSTRUNS,IPL_2019_FACT_SHEET_MOSTWICKETS);
            String sortedDataBestRunsAndWickets=cricketLeagueAnalyser.getBestRunsAndWickets();
            IplSheetDAO[] sortedData=new Gson().fromJson(sortedDataBestRunsAndWickets, IplSheetDAO[].class);
            Assert.assertEquals("Shreyas Iyer",sortedData[sortedData.length-1].player);
            Assert.assertEquals("Marcus Stoinis",sortedData[0].player);
        }catch(CricketLeagueAnalyserException e){
            e.printStackTrace();
        }
    }
}
