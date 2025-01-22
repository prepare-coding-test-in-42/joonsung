import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Integer>> genreSongs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(i);
        }
        
        for (List<Integer> songs: genreSongs.values()) {
            songs.sort((s1, s2) -> {
                if (plays[s2] != plays[s1])
                    return plays[s2] - plays[s1];
                return s1 - s2;
                });
        }
        
        List<String> sortedGenre = new ArrayList<>(genrePlayCount.keySet());
        sortedGenre.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));
        
        List<Integer> album = new ArrayList<>();
        for (String genre: sortedGenre) {
            List<Integer> songs = genreSongs.get(genre);
            for (int i = 0; i < Math.min(2, songs.size()); i++)
                album.add(songs.get(i));
        }
        return album.stream().mapToInt(Integer::intValue).toArray();
    }
}
