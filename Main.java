package org.example;

import java.util.*;


public class Main {
    static List<parca> parcalistesi = new ArrayList<>();
    static int[][] map = new int[3][15];
//3 sutun var ama       satır sayısı parca sayısı kadar olmalı onu henüz ayarlamadım parca sayısını 15 den küçük giriyorum şuan kullanırken




    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("kac adet parca istersiniz :");

        int parcasayisi = scanner.nextInt();


        //    Olustur(parcasayisi);
        //    Listele(parcasayisi);
        //    Yazdir(parcasayisi);
        //    MapOlustur(parcasayisi);
        //    sirala(map);
        //    Yazdir(parcasayisi);
        //    mapDene(parcasayisi);

        StartGame(parcasayisi);


    }

    public static void StartGame(int parcasayisi) {

        Olustur(parcasayisi);
        MapOlustur(parcasayisi);
        sirala(map);
        Yazdir(parcasayisi);


        Scanner scan = new Scanner(System.in);
        while (true) {


            System.out.print("oynatmak istediğin placei gir :");
            int oynanacakplace = scan.nextInt() - 1;

            int placetekienkucuk = PlaceCheck(oynanacakplace);
            if (placetekienkucuk == 100) {

                System.out.println("************bu placete parca yok*****************");
            } else {

                System.out.println("where do you want to move your piece :");
                int gidecekyer = scan.nextInt() - 1;
                Move(placetekienkucuk, oynanacakplace, gidecekyer);
            }

            sirala(map);
            Yazdir(parcasayisi);


        }


    }


    public static void Move(int placetekienkucuk, int oynanacakplace, int gidecekyer) {

        if (PlaceCheck(gidecekyer) == 100 || PlaceCheck(oynanacakplace) < PlaceCheck(gidecekyer)) {

            int placetekiitemsayisi = 0;
            int sutun = oynanacakplace;
            for (int satir = 0; satir < parcalistesi.size(); satir++) {
                if (parcalistesi.get(satir).place == sutun) {

                    placetekiitemsayisi++;

                }

                if (parcalistesi.get(satir).buyukluk == placetekienkucuk) {

                    parcalistesi.get(satir).place = gidecekyer;

                }


            }


          //  mapDene(parcalistesi.size());
          //  cw(5);
            map[gidecekyer][0] = placetekienkucuk;
            map[oynanacakplace][parcalistesi.size() - placetekiitemsayisi] = 0;
            sirala(map);
         //   mapDene(parcalistesi.size());


        }

    }

    public static void cw(int a) {

        for (int i = 0; i < a; i++) {


            System.out.println("");
        }
    }

    public static int PlaceCheck(int place) {

        int enkucuk = 100;

        for (int i = 0; i < parcalistesi.size(); i++) {

            if (parcalistesi.get(i).place == place && enkucuk > parcalistesi.get(i).buyukluk) {

                enkucuk = parcalistesi.get(i).buyukluk;
            }
        }


        return enkucuk;
    }


    public static void MapOlustur(int parcasayisi) {


        int IlkSira = 0;
        int ikinciSira = 0;
        int ucuncuSira = 0;


        int satir1 = 0;
        int satir2 = 0;
        int satir3 = 0;

        for (int index = 0; index < parcasayisi; index++) {


            if (0 == parcalistesi.get(index).place) {

                map[0][satir1] = parcalistesi.get(index).buyukluk;
                //   System.out.println(map[0][index]);
                satir1++;
            }
            if (1 == parcalistesi.get(index).place) {
                map[1][satir2] = parcalistesi.get(index).buyukluk;
                satir2++;
            }
            if (2 == parcalistesi.get(index).place) {
                map[2][satir3] = parcalistesi.get(index).buyukluk;
                satir3++;
            }


        }


    }


    public static void sirala(int[][] a) {

        int[] bir = new int[parcalistesi.size()];
        int[] iki = new int[parcalistesi.size()];
        int[] ucu = new int[parcalistesi.size()];

        for (int sutun = 0; sutun < 3; sutun++) {
            for (int satir = 0; satir < parcalistesi.size(); satir++) {

                bir[satir] = map[0][satir];
                iki[satir] = map[1][satir];
                ucu[satir] = map[2][satir];

            }
        }


        Arrays.sort(bir);
        Arrays.sort(iki);
        Arrays.sort(ucu);

        for (int sutun = 0; sutun < 3; sutun++) {
            for (int satir = 0; satir < parcalistesi.size(); satir++) {


                if (sutun == 0) {

                    map[sutun][satir] = bir[satir];
                    //     System.out.println(map[sutun][satir]);


                } else if (sutun == 1) {
                    map[sutun][satir] = iki[satir];
                    //      System.out.println(map[sutun][satir]);
                } else {
                    //        System.out.println(map[sutun][satir]);
                    map[sutun][satir] = ucu[satir];
                }


            }


        }


    }


    public static void Yazdir(int parcasayisi) {


        // parca saiyisi kadar * olacağı için ve placeler arası 5er boşluk olacağı için

        //satir sutun karismis olabilir kontrol et


        for (int satir = 0; satir < parcasayisi; satir++) {


            for (int sutun = 0; sutun < 3; sutun++) {


                //********************************************
                //    System.out.println(sutun + "   " + satir);
                //********************************************

                int bosluk = parcasayisi - map[sutun][satir];
                int teksayi = 0;
                double boslukbol2 = bosluk / 2;

                if ((double) bosluk / 2 != boslukbol2) {

                    teksayi = 1;
                }

                for (int l = bosluk / 2; l > 0; l--) {

                    if (teksayi == 1) {
                        System.out.print(" ");
                    }
                    System.out.print(" ");

                }


                for (int k = 0; k < map[sutun][satir]; k++) {

                    System.out.print("*");
                }


                for (int l = bosluk / 2; l > 0; l--) {
                    System.out.print(" ");

                }

                System.out.print("   |   ");
            }
            System.out.println();
        }


    }

    public static void mapDene(int parcasayisi) {


        for (int satir = 0; satir < parcasayisi; satir++) {

            for (int sutun = 0; sutun < 3; sutun++) {


                System.out.print(map[sutun][satir]);


            }
            System.out.println();
        }


    }


    public static void Olustur(int parcasayisi) {


        for (int b = 0; b < parcasayisi; b++) {

            int bBirFazlasi = b;


            parcalistesi.add(new parca("parca " + bBirFazlasi, bBirFazlasi, 0, parcasayisi));


        }

    }


    public static void Listele(int parcasayisi) {

        for (int b = 0; b < parcasayisi; b++) {

            System.out.println("isim : " + parcalistesi.get(b).isim + " numara :" + parcalistesi.get(b).number + " place : " + parcalistesi.get(b).place);


        }

    }


    public static class parca {

        String isim;
        int number;
        int place;
        int buyukluk;

        parca(String isim, int number, int place, int parcasayisi) {
            this.isim = isim;
            this.number = number;
            this.place = place;
            this.buyukluk = parcasayisi - number;
        }

    }


}


