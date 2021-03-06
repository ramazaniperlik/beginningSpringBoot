package com.ramazaniperlik.Rest;

import com.ramazaniperlik.DB.Database;
import com.ramazaniperlik.Model.Artist;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArtistController {
    @GetMapping("/artists")
    public List<Artist> getArtists(){
    return Database.artists;
    }
    @GetMapping("/artist/{id}")
    public Artist getArtist(@PathVariable int id){
    return Database.artists.stream().filter(x->x.getId() == id).findFirst().orElse(new Artist());
        //Burada lambda expression yazmazsak id 2 olduğunda listedeki 1. indis değeri getirecek.
    }
    @PostMapping("/artists")
    public Artist addArtist(@RequestBody Artist artist){
        Database.artists.add(artist);
        return artist;
    }
    @PutMapping("/artists")
    public Artist updateArtist(@RequestBody Artist artist){
        var result = Database.artists.stream().filter(x->x.getId()==artist.getId()).findFirst().orElse(null);
        if(result == null)
            return new Artist();
        else{
            result.setName(artist.getName());
            result.setSongs(artist.getSongs());
            return result;
        }
    }
    @DeleteMapping("/artist/{id}")
    public Artist deleteArtist(@PathVariable int id){
        var result = Database.artists.stream().filter(x->x.getId()==id).findFirst().orElse(null);
        if(result!=null)
           Database.artists.remove(result);
        return result;
    }
}
