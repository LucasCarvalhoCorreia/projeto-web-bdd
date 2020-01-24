package br.com.rsinet.hub_bdd.managers;

import br.com.rsinet.hub_bdd.dataProvider.ConfigFileReader;

public class FileReaderManager {

 private static FileReaderManager fileReaderManager = new FileReaderManager();
 private static ConfigFileReader configFileReader;

 private FileReaderManager() {
 }

 public static FileReaderManager getInstance( ) {
       return fileReaderManager;
 }

 public ConfigFileReader getConfigReader() {
 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
 }
}