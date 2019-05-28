DROP TABLE IF EXISTS tracks;

CREATE TABLE tracks (
                        id                    SERIAL,
                        title              VARCHAR(50) NOT NULL,
                        author_name                 VARCHAR(100) NOT NULL,
                        album                 VARCHAR(100) NOT NULL,
                        PRIMARY KEY (id)

);

INSERT INTO tracks (title,author_name,album) VALUES ('Звезда по имени Солнце', 'Виктор Цой', 'Звезда по имени Солнце');
INSERT INTO tracks (title,author_name,album) VALUES ('Невесёлая песня', 'Виктор Цой', 'Звезда по имени Солнце');
INSERT INTO tracks (title,author_name,album) VALUES ('Route 66', 'The Rolling Stones', 'The Rolling Stones');
INSERT INTO tracks (title,author_name,album) VALUES ('L.A. Woman', 'The Doors', 'L.A. Woman');
INSERT INTO tracks (title,author_name,album) VALUES ('Yesterday', 'The Beatles', 'Help!');
INSERT INTO tracks (title,author_name,album) VALUES ('Help!', 'The Beatles', 'Help!');
INSERT INTO tracks (title,author_name,album) VALUES ('Yellow Submarine', 'The Beatles', 'Yellow Submarine');
INSERT INTO tracks (title,author_name,album) VALUES ('It’s All Too Much', 'The Beatles', 'Yellow Submarine');

