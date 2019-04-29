package com.itbuzzpress.chapter5.bean;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.itbuzzpress.chapter5.model.Word;
import com.itbuzzpress.chapter5.qualifier.Anagram;

@ApplicationScoped
public class GenerateWord {

	@Produces
	@Anagram
	public Word createAnagram(){
		List<String> wordList = new ArrayList();
		wordList.add("house");
		wordList.add("garden");
		wordList.add("door");
		wordList.add("window");

		return shuffle(wordList);
	}

	public Word shuffle(List<String> wordList){

		Random rand = new Random();

		int  index = rand.nextInt(wordList.size());
		String word = wordList.get(index);
		List<Character> characters = new ArrayList<Character>();
		for(char c:word.toCharArray()){
			characters.add(c);
		}
		StringBuilder output = new StringBuilder(word.length());
		while(characters.size()!=0){
			int randPicker = (int)(Math.random()*characters.size());
			output.append(characters.remove(randPicker));
		}
		System.out.println("Secret word is "+word);
		return new Word(word, output.toString());
	}

}