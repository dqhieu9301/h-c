create database TH2Bai2;

use TH2Bai2;

CREATE TABLE Sinhvien (
    MaSV char(20) not null primary key,
    ten varchar(30),
    tuoi INT
);

insert into SinhVien(masv , ten , tuoi) values("abc1" , "nam" , 20);
insert into SinhVien(masv , ten , tuoi) values("abc2" , "duc" , 19);
insert into SinhVien(masv , ten , tuoi) values("abc3" , " hieu" , 21);
insert into SinhVien(masv , ten , tuoi) values("abc4" , " duong" , 21);
CREATE TABLE Monhoc (
    MaM char(20) not null primary key,
    ten varchar(30)
);

insert into monhoc(mam , ten) values("c1" , "toan");
insert into monhoc(mam , ten) values("c2" , "hoa");
insert into monhoc(mam , ten) values("c3" , "ly");
insert into monhoc(mam , ten) values("c4" , "ngu van");

CREATE TABLE Hoc (
    MaSV char(20) not null,
    MaM char(20) not null,
    diem float,
    foreign key (MaSV) references Sinhvien(MaSV),
    foreign key (MaM) references Monhoc(MaM)
);

insert into Hoc(MaSV , Mam , diem) values("abc2" , "c1" , 6);
insert into Hoc(MaSV , Mam , diem) values("abc1" , "c1" , 8);
insert into Hoc(MaSV , Mam , diem) values("abc1" , "c3" , 4);
insert into Hoc(MaSV , Mam , diem) values("abc3" , "c2" , 6);


select sv.masv, avg(hoc.diem) 
from sinhvien sv inner join hoc on hoc.masv = sv.masv 
group by sv.masv;

select sv.MaSV, avg(hoc.diem) as tb
from Sinhvien sv
inner join hoc on hoc.MaSV = sv.MaSV
GROUP BY sv.MaSV
having avg(hoc.diem) > 5.0 ;

select * from Sinhvien 
where MaSV in
 (select MaSV from Hoc group by MaSV);
 
select * from Sinhvien 
where MaSV not in
 (select MaSV from Hoc group by MaSV)
