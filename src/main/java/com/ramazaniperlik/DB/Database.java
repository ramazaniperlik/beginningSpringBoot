package com.ramazaniperlik.DB;

import com.ramazaniperlik.Model.Artist;
import com.ramazaniperlik.Model.Lyric;
import com.ramazaniperlik.Model.Song;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();
    public static List<Lyric> lyrics = new ArrayList<>();
    public static void fill(){
        artists.add(new Artist(1,"Artist1"));
        artists.add(new Artist(2,"Artist2"));
        artists.add(new Artist(3,"Artist3"));
        songs.add(new Song(1,"song1",2020));
        songs.add(new Song(2,"song2",2021));
        songs.add(new Song(3,"song3",2022));
        songs.add(new Song(4,"song4",2023));
        lyrics.add(new Lyric(1,"Türkçe",songs.get(0)));
        lyrics.add(new Lyric(2,"İngilizce",songs.get(0)));
        lyrics.add(new Lyric(3,"Türkçe",songs.get(1)));
        lyrics.add(new Lyric(4,"İngilizce",songs.get(1)));
        artists.get(0).addSong(songs.get(0));//İlk artist ilk şarkıya sahip
        artists.get(1).addSong(songs.get(0));//İkinci artist ik şarkıya sahip

        artists.get(0).addSong(songs.get(1));//İlk artist ikinci şarkıya sahip
        artists.get(0).addSong(songs.get(2));//ilk artist üçüncü şarkıya sahip

        artists.get(2).addSong(songs.get(3));//üçüncü artist dördüncü şarkıya sahip

        /*Karşılıklı manyToMany ilişki için songs tarafından da bağlama yapıyoruz.*/

        songs.get(0).addArtist(artists.get(0));//1.şarkı 1.artiste ait
        songs.get(0).addArtist(artists.get(1));//1.şarkı 2.artiste ait

        songs.get(1).addArtist(artists.get(0));
        songs.get(2).addArtist(artists.get(0));

        songs.get(3).addArtist(artists.get(2));

        /*Hangi şarkının hangi lyric'e ait olduğunu da ilişkilendiriyoruz*/

        songs.get(0).addLyric(lyrics.get(0));//1.şarkı 1.lyric'i var
        songs.get(0).addLyric(lyrics.get(1));//1.şarkının 2.lyric'i de var
        songs.get(1).addLyric(lyrics.get(2));//2.şarkının 3.lyric'i var
        songs.get(1).addLyric(lyrics.get(3));//2.şarkının 4.lyric'i de var


    }

}
