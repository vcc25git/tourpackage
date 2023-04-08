
-- Adding a few initial tour packages 
INSERT INTO tour_detail (tour_detail_id, description, price)VALUES (1, 'England tour', 1100), (2, 'USA tour', 3200), (3, 'Ireland tour', 1550), (4, 'France tour', 1000) ;
insert into tour_package(tour_id, tourname, cat_Id, tour_detail_id) values (1,'London', 1, 1);
insert into tour_package(tour_id, tourname, cat_Id, tour_detail_id) values (2, 'New York', 2, 2);
insert into tour_package(tour_id, tourname, cat_Id, tour_detail_id) values (3, 'Dublin', 1, 3);
insert into tour_package(tour_id, tourname, cat_Id, tour_detail_id) values (4, 'Paris', 1, 4);
