package com.fozimat.catafozmovie.utils

import com.fozimat.catafozmovie.data.source.local.entity.MoviesEntity
import com.fozimat.catafozmovie.data.source.remote.response.MovieResponse

object DataDummy {

    fun generateDummyMovies(): List<MoviesEntity> {

        val movies = ArrayList<MoviesEntity>()

        movies.add(
            MoviesEntity(
                "Alita: Battle Angel",
                2019,
                "Action, Fantasy, Adventure",
                "When Alita awakens with no memories of who she is in a future world she doesn't know, she is captured by Ido, a compassionate doctor who realizes that somewhere in the shell of this abandoned cyborg is the heart and soul of an extraordinary young woman",
                "2h 2m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/quWP5VIzTUf0Hr8AJZLloM6js8I.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Bohemian Rhapsody",
                2018,
                "Musical, Drama, Science",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2h 15m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Fantastic Beasts: The Crimes of Grindelwald",
                2018,
                "Adventure, Fantasy, Drama",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead.",
                "2h 14m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Glass",
                2019,
                "Thriller, Drama, Science Fiction",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2h 9m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xt88UO9K0SubHWDGYrW2Mr9CKa6.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "How to Train Your Dragon: The Hidden World",
                2019,
                "Animation, Family, Adventure",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "1h 44m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Avengers: Infinity War",
                2018,
                "Adventure, Action, Science",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality.",
                "2h 29m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Master Z: Ip Man Legacy",
                2018,
                "Action",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "1h 47m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Mortal Engines",
                2018,
                "Adventure, Science Fiction",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "2h 9m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Overlord",
                2018,
                "Horror, War, Science Fiction",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, they also must fight against something else.",
                "1h 50m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/l76Rgp32z2UxjULApxGXAPpYdAP.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Wreck-It Ralph",
                2012,
                "Family, Animation, Comedy",
                "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders.",
                "1h 41m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nsUAgWCxqbTD9wkKrv3nBGH2DVk.jpg"
            )
        )
        return movies
    }

    fun generateTvShow(): List<MoviesEntity> {

        val movies = ArrayList<MoviesEntity>()

        movies.add(
            MoviesEntity(
                "Arrow",
                2012,
                "Crime, Drama, Mystery, Action",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "42m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Doom Patrol",
                2019,
                "Sci-Fi & Fantasy, Comedy, Drama",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control.",
                "49m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Dragon Ball Super",
                2015,
                "Animation, Adventure, Fantasy",
                "With Majin Boo defeated half-a-year prior, peace returns to Earth, where Son Goku (now a radish farmer) and his friends now live peaceful lives. However, a new threat appears in the form of Beerus, the God of Destruction. Considered the most terrifying being in the entire universe.",
                "24m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/kbhu0tIv5E1PbAw2YPjrhoQ7I1s.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Family Guy",
                1999,
                "Animation, Comedy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world).",
                "22m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "The Flash",
                2022,
                "Action, Adventure, Science Fiction",
                "The Flash travels back in time to prevent the murder of his mother, an act which disrupts time significantly",
                "1h 56m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fki3kBlwJzFp8QohL43g9ReV455.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Game of Thrones",
                2011,
                "Adventure, Action, Science Fiction",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "1h",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gwPSoYUHAKmdyVywgLpKKA4BjRr.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Naruto Shippuden the Movie",
                2007,
                "Family, Action, Animation",
                "Demons that once almost destroyed the world, are revived by someone. To prevent the world from being destroyed, the demon has to be sealed and the only one who can do it is the shrine maiden Shion from the country of demons, who has two powers; one is sealing demons and the other is predicting the deaths of humans.",
                "1h 34m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vDkct38sSFSWJIATlfJw0l3QOIR.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Shameless",
                2011,
                "Drama, Comedy",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "57m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ySqdzgULM0SJfIqcYmVIDw7VJgz.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "Supergirl",
                2015,
                "Drama, Sci-Fi & Fantasy",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "42m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vqBsgL9nd2v04ZvCqPzwtckDdFD.jpg"
            )
        )
        movies.add(
            MoviesEntity(
                "The Simpsons",
                1989,
                "Family, Animation, Comedy",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "22m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/k5UALlcA0EnviaCUn2wMjOWYiOO.jpg"
            )
        )
        return movies
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                "Alita: Battle Angel",
                2019,
                "Action, Fantasy, Adventure",
                "When Alita awakens with no memories of who she is in a future world she doesn't know, she is captured by Ido, a compassionate doctor who realizes that somewhere in the shell of this abandoned cyborg is the heart and soul of an extraordinary young woman",
                "2h 2m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/quWP5VIzTUf0Hr8AJZLloM6js8I.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Bohemian Rhapsody",
                2018,
                "Musical, Drama, Science",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2h 15m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Fantastic Beasts: The Crimes of Grindelwald",
                2018,
                "Adventure, Fantasy, Drama",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead.",
                "2h 14m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Glass",
                2019,
                "Thriller, Drama, Science Fiction",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2h 9m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xt88UO9K0SubHWDGYrW2Mr9CKa6.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "How to Train Your Dragon: The Hidden World",
                2019,
                "Animation, Family, Adventure",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "1h 44m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Avengers: Infinity War",
                2018,
                "Adventure, Action, Science",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality.",
                "2h 29m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Master Z: Ip Man Legacy",
                2018,
                "Action",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "1h 47m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Mortal Engines",
                2018,
                "Adventure, Science Fiction",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "2h 9m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Overlord",
                2018,
                "Horror, War, Science Fiction",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, they also must fight against something else.",
                "1h 50m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/l76Rgp32z2UxjULApxGXAPpYdAP.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Wreck-It Ralph",
                2012,
                "Family, Animation, Comedy",
                "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders.",
                "1h 41m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nsUAgWCxqbTD9wkKrv3nBGH2DVk.jpg"
            )
        )
        return movies
    }

    fun generateRemoteDummyTvShow(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                "Arrow",
                2012,
                "Crime, Drama, Mystery, Action",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "42m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Doom Patrol",
                2019,
                "Sci-Fi & Fantasy, Comedy, Drama",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control.",
                "49m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Dragon Ball Super",
                2015,
                "Animation, Adventure, Fantasy",
                "With Majin Boo defeated half-a-year prior, peace returns to Earth, where Son Goku (now a radish farmer) and his friends now live peaceful lives. However, a new threat appears in the form of Beerus, the God of Destruction. Considered the most terrifying being in the entire universe.",
                "24m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/kbhu0tIv5E1PbAw2YPjrhoQ7I1s.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Family Guy",
                1999,
                "Animation, Comedy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world).",
                "22m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "The Flash",
                2022,
                "Action, Adventure, Science Fiction",
                "The Flash travels back in time to prevent the murder of his mother, an act which disrupts time significantly",
                "1h 56m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fki3kBlwJzFp8QohL43g9ReV455.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Game of Thrones",
                2011,
                "Adventure, Action, Science Fiction",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "1h",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gwPSoYUHAKmdyVywgLpKKA4BjRr.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Naruto Shippuden the Movie",
                2007,
                "Family, Action, Animation",
                "Demons that once almost destroyed the world, are revived by someone. To prevent the world from being destroyed, the demon has to be sealed and the only one who can do it is the shrine maiden Shion from the country of demons, who has two powers; one is sealing demons and the other is predicting the deaths of humans.",
                "1h 34m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vDkct38sSFSWJIATlfJw0l3QOIR.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Shameless",
                2011,
                "Drama, Comedy",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "57m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ySqdzgULM0SJfIqcYmVIDw7VJgz.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "Supergirl",
                2015,
                "Drama, Sci-Fi & Fantasy",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "42m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vqBsgL9nd2v04ZvCqPzwtckDdFD.jpg"
            )
        )
        movies.add(
            MovieResponse(
                "The Simpsons",
                1989,
                "Family, Animation, Comedy",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "22m",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/k5UALlcA0EnviaCUn2wMjOWYiOO.jpg"
            )
        )
        return movies
    }
}