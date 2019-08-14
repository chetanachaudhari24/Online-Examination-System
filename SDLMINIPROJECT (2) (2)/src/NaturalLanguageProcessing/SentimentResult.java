/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NaturalLanguageProcessing;

/**
 *
 **/
public class SentimentResult {

 String sentimentType;

 int sentimentScore;

 SentimentClassification sentimentClass;

 public String getSentimentType() {

  return sentimentType;

 }

 public void setSentimentType(String sentimentType) {

  this.sentimentType = sentimentType;

 }

 public int getSentimentScore() {

  return sentimentScore;

 }

 public void setSentimentScore(int sentimentScore) {

  this.sentimentScore = sentimentScore;

 }

 public SentimentClassification getSentimentClass() {

  return sentimentClass;

 }

 public void setSentimentClass(SentimentClassification sentimentClass) {

  this.sentimentClass = sentimentClass;

 }

}
