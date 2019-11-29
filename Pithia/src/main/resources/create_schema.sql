create table XRHSTES
(
    onoma_xrhsth        varchar(255) not null,
    email               varchar(255),
    epwnhmo             varchar(255),
    hmeromhnia_gennhshs date,
    kwdikos             varchar(255),
    onoma               varchar(255),
    primary key (onoma_xrhsth)
);

create table FOITITES
(
    onoma_xrhsth_foititi varchar(255) not null,
    primary key (onoma_xrhsth_foititi)
);


create table KATHIGITES
(
    onoma_xrhsth_kathigiti varchar(255) not null,
    primary key (onoma_xrhsth_kathigiti)
);

create table THEWRIES
(
    onoma_mathimatos       varchar(255) not null,
    eksamhno               varchar(255),
    onoma_xrhsth_kathigiti varchar(255) not null,
    primary key (onoma_mathimatos)
);

create table THEWRIA_PARAKOLOUTHOUN
(
    onoma_thewrias       varchar(255) not null,
    onoma_xrhsth_foititi varchar(255) not null,
    primary key (onoma_thewrias, onoma_xrhsth_foititi)
);

create table PROAPAITOUMENA
(
    onoma_mathimatos                 varchar(255) not null,
    onoma_proapaitoumenou_mathimatos varchar(255) not null,
    primary key (onoma_mathimatos, onoma_proapaitoumenou_mathimatos)
);

create table ERGASTHRIA
(
    onoma_ergasthriou      varchar(255) not null,
    onoma_xrhsth_kathigiti varchar(255) not null,
    onoma_thewrias varchar(255) not null,
    CONSTRAINT FK_ERGASTHRIA_ONOMA_THEWRIAS FOREIGN KEY(onoma_thewrias) REFERENCES THEWRIES,
    primary key (onoma_ergasthriou,onoma_thewrias)
);

create table ERGASTHRIA_PARAKOLOUTHOUN
(
    onoma_ergasthriou    varchar(255) not null,
    onoma_thewrias varchar(255) not null,
    onoma_xrhsth_foititi varchar(255) not null,
    primary key (onoma_ergasthriou, onoma_xrhsth_foititi,onoma_thewrias)
);

create table KATHIGITES_ERGASTHRIWN
(
    onoma_thewrias         varchar(255) not null,
    onoma_xrhsth_kathigiti varchar(255) not null,
    primary key (onoma_thewrias, onoma_xrhsth_kathigiti)
);

create table APOUSIES
(
    onoma_ergasthriou    varchar(255) not null,
    onoma_thewrias varchar(255) not null,
    arithmos_apoysiwn    int4         not null,
    onoma_xrhsth_foititi varchar(255),
    primary key(onoma_ergasthriou,onoma_xrhsth_foititi,onoma_thewrias)
);

create table VATHMOI_ERGASTHRIOU
(
    onoma_ergasthriou    varchar(255) not null,
    onoma_thewrias varchar(255) not null,
    onoma_xrhsth_foititi varchar(255) not null,
    vathmos_ergasthriou  float8,
    primary key (onoma_ergasthriou,onoma_xrhsth_foititi,onoma_thewrias)
);

create table VATHMOI_THEWRIAS
(
    onoma_thewrias       varchar(255) not null,
    onoma_xrhsth_foititi varchar(255) not null,
    vathmos_thewrias     float8,
    primary key (onoma_thewrias,onoma_xrhsth_foititi)
);

create table ROLOI_XRISTWN
(
    onoma_xrhsth varchar(255) not null,
    rolos        varchar(255) not null,
    primary key (onoma_xrhsth, rolos)
);


alter table APOUSIES
    add constraint FK_APOUSIES_ONOMA_XRHSTH_FOITITI
        foreign key (onoma_xrhsth_foititi)
            references FOITITES;


alter table APOUSIES
    add constraint FK_APOUSIES_ONOMA_ERGASTHRIOU
        foreign key (onoma_ergasthriou,onoma_thewrias)
            references ERGASTHRIA;


alter table ERGASTHRIA
    add constraint FK_ERGASTHRIA_ONOMA_XRHSTH_KATHIGITI
        foreign key (onoma_xrhsth_kathigiti)
            references KATHIGITES;


alter table ERGASTHRIA_PARAKOLOUTHOUN
    add constraint FK_ERGASTHRIA_PARAKOLOUTHOUN_ONOMA_XRHSTH_FOITITI
        foreign key (onoma_xrhsth_foititi)
            references FOITITES;


alter table ERGASTHRIA_PARAKOLOUTHOUN
    add constraint FK_ERGASTHRIA_PARAKOLOUTHOUN_ONOMA_ERGASTHRIOU
        foreign key (onoma_ergasthriou,onoma_thewrias)
            references ERGASTHRIA;

alter table FOITITES
    add constraint FK_FOITITES_ONOMA_XRHSTH_FOITITI
        foreign key (onoma_xrhsth_foititi)
            references XRHSTES;


alter table KATHIGITES
    add constraint FK_KATHIGITES_ONOMA_XRHSTH_KATHIGITI
        foreign key (onoma_xrhsth_kathigiti)
            references XRHSTES;


alter table KATHIGITES_ERGASTHRIWN
    add constraint FK_KATHIGITES_ERGASTHRIWN_ONOMA_XRHSTH_KATHIGITI
        foreign key (onoma_xrhsth_kathigiti)
            references KATHIGITES;


alter table KATHIGITES_ERGASTHRIWN
    add constraint FK_KATHIGITES_ERGASTHRIWN_ONOMA_THEWRIAS
        foreign key (onoma_thewrias)
            references THEWRIES;


alter table PROAPAITOUMENA
    add constraint FK_PROAPAITOUMENA_ONOMA_PROAPAITOUMENOU_MATHIMATOS
        foreign key (onoma_proapaitoumenou_mathimatos)
            references THEWRIES;


alter table PROAPAITOUMENA
    add constraint FK_PROAPAITOUMENA_ONOMA_MATHIMATOS
        foreign key (onoma_mathimatos)
            references THEWRIES;

alter table ROLOI_XRISTWN
    add constraint FK_ROLOI_XRISTWN_ONOMA_XRHSTH
        foreign key (onoma_xrhsth)
            references XRHSTES;


alter table THEWRIA_PARAKOLOUTHOUN
    add constraint FK_THEWRIA_PARAKOLOUTHOUN_ONOMA_XRHSTH_FOITITI
        foreign key (onoma_xrhsth_foititi)
            references FOITITES;


alter table THEWRIA_PARAKOLOUTHOUN
    add constraint FK_THEWRIA_PARAKOLOUTHOUN_ONOMA_THEWRIAS
        foreign key (onoma_thewrias)
            references THEWRIES;


alter table THEWRIES
    add constraint FK_THEWRIAS_ONOMA_XRHSTH_KATHIGITI
        foreign key (onoma_xrhsth_kathigiti)
            references KATHIGITES;


alter table VATHMOI_ERGASTHRIOU
    add constraint FK_VATHMOI_ERGASTHRIOU_ONOMA_XRHSTH_FOITITI
        foreign key (onoma_xrhsth_foititi)
            references FOITITES;


alter table VATHMOI_ERGASTHRIOU
    add constraint FK_VATHMOI_ERGASTHRIOU_ONOMA_ERGASTHRIOU
        foreign key (onoma_ergasthriou,onoma_thewrias)
            references ERGASTHRIA;


alter table VATHMOI_THEWRIAS
    add constraint FK_VATHMOI_THEWRIAS_ONOMA_XRHSTH_FOITITI
        foreign key (onoma_xrhsth_foititi)
            references FOITITES;


alter table VATHMOI_THEWRIAS
    add constraint VATHMOI_THEWRIAS_ONOMA_THEWRIAS
        foreign key (onoma_thewrias)
            references THEWRIES;


