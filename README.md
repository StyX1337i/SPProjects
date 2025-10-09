# Book Model - Composite Pattern Implementation

Acest proiect implementează modelul de carte folosind pattern-ul Composite în C#.

## Structura Proiectului

- **IBookElement** - Interfața comună pentru toate elementele
- **Author** - Clasa pentru autor
- **Book** - Clasa principală care conține toate componentele
- **Chapter** - Reprezintă un capitol
- **SubChapter** - Reprezintă un subcapitol
- **Image** - Reprezintă o imagine
- **Paragraph** - Reprezintă un paragraf
- **Table** - Reprezintă un tabel
- **TableOfContents** - Reprezintă cuprinsul

## Relații UML

- **Compoziție**: Book → TableOfContents, Book → Chapter, Chapter → SubChapter, SubChapter → {Image, Paragraph, Table}
- **Asociere**: Author ↔ Book

## Cum să rulezi

```bash
dotnet run
```

## Rezultat

```
Carte: Amintiri din copilărie
Autor: Ion Creangă
Cuprins:
1. Introducere
Capitol: Introducere
Subcapitol: Copilăria
Paragraf: Text paragraf 1
Imagine: imagine1.jpg
Tabel: Tabel 1
```
