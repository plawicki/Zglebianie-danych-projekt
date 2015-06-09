# Prawo Zipf'a


### Wstęp

Prawo Zipf'a – jest to prawo, które mówi, iż częstotliwość występowania słów w tekście powinna być odwrotnie proporcjonalna do pozycji w rankigu, gdzie ranking jest tworzony poprzez zliczenie częstotliwości występowania słów oraz posortowania malejąco powstałej listy. Tzn. pierwsze napotkane przez algorytm słowo będzie występowało około dwa razy częściej niż drugie słowo z rankingu.


### Narzędzia

Do rozpatrywania tego zagadnienia użyłem napisanego przeze mnie algorytmu w języku Java. Do uruchomienia projektu lokalnie wystarczy zainstalowany pakie jre w wersji 8.


### Dane

Teksty książek do analizy zostały zaczerpnięte z pl.wikisource.org, z portalu autocentrum.pl, oraz ze strony ae-lib.org.ua/texts-c
Do testów wybrałem następujące książki/artykuły:

* Henryk Sienkiewicz „Krzyżacy” cz.2
* Bolesław Prus „Lalka” tom I
* 3 najnowsze publikacje z portalu autocentrum.pl
* John R.R. Tolkien „The Lord Of The Rings: Return Of The King” book V

W tekstach zostały usunięte numery oraz tytuły rozdziałów, dane są załączone wraz z kodem programu na githubowym repozytorium tutaj. Program należy odpowiednio uruchomić z linii poleceń systemu z podaniem argumentów w postaci ścieżek do plików, które mają zostać przeanalizowane.


### Opis eksperymentów

Do sprawdzenia prawa Zipf'a dla polskich tekstów użyłem metody zliczania słów w tekście, taka metoda pomoże w prosty sposób stwierdzić czy prawo Zipfa jest prawdziwe.
	Jak wspomniałem wcześniej do zbadania tego zagadnienia wykorzystuję własny algorytm, którego działanie najłatwiej będzie zademonstrować na przykładzie. Załóżmy, że mam do przeanalizowania następujące zdanie: 

```
„— Waryat! waryat!... Awanturnik!... Józiu, przynieśno jeszcze piwa. A która to butelka?”.
```

Algorytm w pierwszym kroku zamieni wszyskie duże litery na małe, oraz usunie znaki specjalne, których nie opisuje prawo Zipf'a. Tekst będzie wyglądał w następujący sposób:

```
„ waryat waryat awanturnik józiu przynieśno jeszcze piwa a która to butelka”
```

W kolejnych krokach algorytm podzieli tekst na listę słów oraz usunie słowa które są puste, lista przy użyciu przykładowego zdania będzie wyglądała tak:

```
 [waryat, waryat, awanturnik, józiu, przynieśno, jeszcze, piwa, a, która, to ,butelka]
```

Kolejnym krokiem jest zliczenie występowania słów w tablicy, w tym kroku powstanie mapa słowno-numeryczna:

```
{[waryat: 2], [awanturnik: 1], [józiu: 1], [przynieśno: 1], [jeszcze: 1], [piwa: 1], [a: 1], [która: 1], [to: 1], [butelka: 1]}
```

Ostatnim krokiem algorytmu jest posortowanie malejąco powstałej mapy, w tym przykładzie mapa zostanie bez zmian. Przy tym przykładzie ciężko stwierdzić czy prawo Zipf'a działa, ponieważ jest to zbyt krótki przykład.

## Wyniki

#### 1. ***Publikacje z portalu autocentrum.pl***; Liczba słów: 2888

wykres ilości występowań słów w tekście:

![alt text](https://github.com/true-or-false/Zglebianie-danych-projekt/blob/master/img/autocentrum.png?raw=true "Wykres autocentrum")


#### 3. ***„Krzyżacy”***; Liczba słów: 23379

wykres ilości występowań słów w tekście:

![alt text](https://github.com/true-or-false/Zglebianie-danych-projekt/blob/master/img/krzyzacy.png?raw=true "Wykres Krzyżaków")

#### 4. ***„Lalka”***; Liczba słów: 74923

wykres ilości występowań słów w tekście:

![alt text](https://github.com/true-or-false/Zglebianie-danych-projekt/blob/master/img/lalka.png?raw=true "Wykres Lalki")

#### 5. ***„The Lord Of The Rings: Return Of The King”***; Liczba słów: 132722

wykres ilości występowań słów w tekście:

![alt text](https://github.com/true-or-false/Zglebianie-danych-projekt/blob/master/img/lotr.png?raw=true "Wykres LOTR")