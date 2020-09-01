package com.example.belajaroop.data

import com.example.belajaroop.database.Quis

object DataDummy {

    fun generateQuis(): List<Quis>{
        val quis = ArrayList<Quis>()

        quis.add(
            Quis(1,
            "Soal 1",
            "Apasaja tahap dalam membuat sebuah objek pada Java :",
            "Deklarasi dan Inisialisasi",
            "Instansiasi dan Inisialisasi",
            "Deklarasi, Instansiasi dan Inisialisasi",
            "Inisialisasi",
            "Deklarasi, Instansiasi dan Inisialisasi"
            )
        )
        quis.add(
            Quis(2,
                "Soal 2",
                "Nama lain dari istilah pewarisan adalah ...",
                "Inheritance",
                "Interface",
                "Overriding",
                "Overloading",
                "Inheritance"
            )
        )
        quis.add(
            Quis(3,
                "Soal 3",
                "Keyword penting dalam java dalam hal exception handing adalah ...",
                "Try",
                "Catch",
                "Finally",
                "Semua jawaban benar",
                "Semua jawaban benar"
            )
        )
        quis.add(
            Quis(4,
                "Soal 4",
                "Sebuah kemampuan yang membolehkan sebuah class mempunyai 2 atau lebih method dengan nama yang sama namun yang membedakan adalah parameternya disebut …",
                "Polimorfisme",
                "Overriding",
                "Overloading",
                "Inheritance",
                "Overloading"
            )
        )
        quis.add(
            Quis(5,
                "Soal 5",
                "Method yang namanya sama dengan nama kelas disebut:",
                "Constructor",
                "Rekursive",
                "Overriding",
                "Overloading",
                "Constructor"
            )
        )
        quis.add(
            Quis(6,
                "Soal 6",
                "Sebutkan tiga prinsip utama dalam Pemrograman Berorientasi Obyek",
                "Public, Protected, Private",
                "Inheritance, Polymorphism, Encapsulation",
                "Polymorphism, Inheritance, Class",
                "Encapsulation, Polymorphism, Extend",
                "Inheritance, Polymorphism, Encapsulation"
            )
        )
        quis.add(
            Quis(7,
                "Soal 7",
                "Kumpulan dari method-method yang belum terdapat operasi di dalam tubuh method tersebut disebut ...",
                "Abstract class",
                "Inheritance",
                "Interface",
                "Method abstract",
                "Interface"
            )
        )
        quis.add(
            Quis(8,
                "Soal 8",
                "Abstraksi dari sesuatu yang mewakili dunia nyata adalah pengertian...",
                "Abstaksi",
                "Atribut",
                "Objek",
                "Method",
                "Objek"
            )
        )
        quis.add(
            Quis(9,
                "Soal 9",
                "Class yang mempunyai sedikitnya satu abstract metode disebut ...",
                "Abstract class",
                "Class",
                "Implementasi",
                "Interface",
                "Abstract class"
            )
        )
        quis.add(
            Quis(10,
                "Soal 10",
                "Method yang bersifat static berarti…",
                "Diambil dengan membuat sebuah object dari class tersebut",
                "Dapat mengakses anggota static dan non static dari class",
                "Dapat menunjuk pada this dan super",
                "Dapat diambil tanpa membuat sebuah object dari class tersebut",
                "Dapat diambil tanpa membuat sebuah object dari class tersebut"
            )
        )


        return quis
    }
}