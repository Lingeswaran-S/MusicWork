package com.te.assesment.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MusicApp {
	static Scanner input = new Scanner(System.in);
	static Process p = new Process(input);

	public static void main(String[] args) throws InterruptedException {
		Comparator<Music> idSort = (Music m1, Music m2) -> {
			if (m1.getSongID() > m2.getSongID())
				return 1;
			else if (m1.getSongID() < m2.getSongID())
				return -1;
			return 0;

		};
		int id = 105;

		LinkedList<Music> songList = new LinkedList<Music>();
		songList.add(new Music(0, "Ransom", "David", "Attitude", "E:\\Songs",
				"ARESA, UMPI, UMPG Publishing, LatinAutor - UMPG, AMRA, UNIAO BRASILEIRA DE EDITORAS DE MUSICA - UBEM, BMI - Broadcast Music Inc., ASCAP, LatinAutor, CMRRA, LatinAutorPerf, and 13 Music Rights Societies"));
		songList.add(new Music(0, "Let-Me-Love", "Justin-Biber", "SurpriseLove", "E:\\Songs",
				"\"Let Me Love You\" is written in the key of C minor with a tempo of 100 beats per second common time"));
		songList.add(new Music(0, "Sia-Unstopable", "sia", "Motivational", "E:\\Songs",
				"The song was written by Sia and Christopher Braide, and produced by Jesse Shatkin. It was released as the album's final promotional single on 21 January 2016"));
		songList.add(new Music(0, "Dusk Till let Down", "Zayn", "Broken", "E:\\Songs",
				"Dusk Till Dawn\" is a song recorded by English singer and songwriter Zayn featuring Australian singer and songwriter Sia. It was released on 8 September"));
		songList.add(new Music(0, "MeandMy", "Rixiton", "Face-It", "E:\\Songs",
				"In 2012, the band started as a four-piece called Relics and then became known as the band Rixton from 2013 onwards. Their debut single as Rixton, \"Me and My "));
		p.arrangeID(songList);
		boolean bk = true;

		do {
			System.out.println(
					"Press.....\n1-Play a Song\n2-Search a Song\n3-Show All Songs\n4-Operate On Song Database \n5-Exit\n-----------------------------------------------------------");
			int option = input.nextInt();

			switch (option) {
			case 1: {
				System.out.println("Press.....\nA-Play All Songs\nB-Play Songs Randomly\nC-Play a Particular Song");
				String option1 = input.next().toLowerCase();
				switch (option1) {
				case "a": {
					LinkedList<Music> orderedSongs = (LinkedList<Music>) songList.clone();
					Collections.sort(orderedSongs);
					p.playAllSong(orderedSongs);
					break;
				}
				case "b": {
					Collections.shuffle(songList);
					p.playAllSong(songList);
					break;

				}
				case "c": {
					p.songSearch(songList);
					break;

				}
				case "d": {
					break;
				}
				default: {
					System.out.println("Invalid Option");
					break;
				}
				}
				break;

			}
			case 2: {
				p.songSearchDisplay(p.search(songList, 2));
				break;

			}
			case 3: {
				Collections.sort(songList);
				p.displayAllSongs(songList);
				break;
			}
			case 4: {
				System.out.println("Press \nA-Add Song\nB-Edit Song\nC-Delete Song");
				String op = input.next();
				switch (op.toLowerCase().substring(0, 1)) {
				case "a": {

					System.out.println("Enter SongTitle ?");
					String sT = input.next();
					System.out.println("Enter ArtistName ?");
					String aN = input.next();
					System.out.println("Enter AlbumName ?");
					String alN = input.next();
					System.out.println("Enter SongLocation ?");
					String sL = input.next();
					System.out.println("Enter Song Description ?");
					String sD = input.next();
					id++;
					songList.add(new Music(id, sT, aN, alN, sL, sD));
					p.arrangeID(songList);
					System.out.println("Added Successfully.....");
					break;
				}
				case "b": {
					// LinkedList<Integer> idCollect = new LinkedList<Integer>();
					LinkedList<Music> now = p.search(songList, 1);

					for (Music music : now) {
						System.out.println("Successfully Founded a Song ::" + music.getSongTitle());
						System.out.println("Do you want to edit this song?\n1-Yes\n2-Exit or Go next");
						int eOP = input.nextInt();
						if (eOP == 1) {
							System.out.println("ReEnter SongTitle or NA ?");

							String r1 = input.next();
							if (!(r1.toLowerCase().substring(0, 2).equalsIgnoreCase("na"))) {
								music.setSongTitle(r1);
							}

							System.out.println("ReEnter ArtistName ?");

							String r2 = input.next();
							if (!(r2.toLowerCase().substring(0, 2).equalsIgnoreCase("na"))) {
								music.setArtistName(r2);
							}

							System.out.println("ReEnter AlbumName ?");

							String r3 = input.next();
							if (!(r3.toLowerCase().substring(0, 2).equalsIgnoreCase("na"))) {
								music.setAlbumName(r3);

							}

							System.out.println("ReEnter SongLocation ?");

							String r4 = input.next();
							if (!(r4.toLowerCase().substring(0, 2).equalsIgnoreCase("na"))) {
								music.setSongLocation(r4);
							}

							System.out.println("ReEnter Song Description ?");

							String r5 = input.next();
							if (!(r5.toLowerCase().substring(0, 2).equalsIgnoreCase("na"))) {
								music.setSongDescription(r5);

							}

						}

					}
					System.out.println("Edited Successfully.....\n");
					break;

				}
				case "c": {
					System.out.println("Enter Song ID for Delete.....");
					int dID = input.nextInt();
					Iterator<Music> it = songList.iterator();
					while (it.hasNext()) {
						if (it.next().getSongID() == dID) {
							it.remove();
							break;
						}
					}
					p.arrangeID(songList);
					System.out.println("Deleted Successfully.....\n");
					break;

				}
				}
				break;

			}
			case 5: {
				System.out.println("Bye........");
				bk = false;

			}
			}

		} while (bk);
	}

}