CREATE DATABASE linkedID_DB;

CREATE TABLE countries
(
    ID_country SERIAL NOT NULL primary key,
    country varchar(255)
);

CREATE TABLE cities
(
    ID_city SERIAL NOT NULL primary key,
    city varchar(255),
    country_ID int references countries(ID_country)
);

CREATE TABLE job_department
(
    ID_department SERIAL NOT NULL primary key,
    department_name varchar(255)
);

CREATE TABLE job_title
(
    ID_jobTitle SERIAL NOT NULL primary key,
    jobTitle_list varchar(255),
    ID_department int references job_department(ID_department)
);

CREATE TABLE users
(
ID SERIAL NOT NULL primary key,
    username varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    birthdate date,
    user_country int references countries(ID_country),
    user_city int references cities(ID_city),
    education varchar (255),
    current_work_place varchar(255),
    job_search int references job_title(ID_jobTitle),
    creation_date timestamp
);

CREATE TABLE messages
(
    ID_massage SERIAL NOT NULL primary key,
    sender_ID int references users(ID),
    message_text varchar (5000),
    recipient_ID int references users(ID),
    creation_date_message timestamp
);

CREATE TABLE posts
(
    ID_post SERIAL NOT NULL primary key,
    sender_ID int references users(ID),
    post_text varchar(5000),
    creation_date_post timestamp
);

insert into countries (country)
values ('Ukraine'),
       ('USA'),
       ('Spain'),
       ('Italy');

insert into cities (city,country_id)
values ('Dnipro', 1),
       ('Kyiv',1),
       ('Lviv',1),
       ('Washington DC',2),
       ('New York',2),
       ('Los Angeles',2),
       ('Madrid',3),
       ('Barcelona',3),
       ('Valencia',3),
       ('Rome', 4),
       ('Milan',4),
       ('Palermo',4);

insert into job_department (department_name)
values ('Sales'),
       ('Production'),
       ('IT_department'),
       ('Accounting'),
       ('Purchasing_department');

insert into job_title(jobtitle_list, id_department)
values ('Sales director',1),
       ('National manager',1),
       ('Key account manager',1),
       ('Manager`s assistant',1),
       ('Wholesale trade manager',1),
       ('Production director',2),
       ('Storekeeper',2),
       ('Production worker',2),
       ('IT department director',3),
       ('Java developer',3),
       ('JavaScript developer',3),
       ('C++ developer',3),
       ('Purchasing_department director',4),
       ('Purchasing manager',4),
       ('Foreign trade manager',4);

insert into users (username, first_name, last_name, birthdate, user_country, user_city, education, current_work_place, job_search, creation_date)
values ('maximov_max', 'Max', 'Maximov', '1982-10-28',1,1,'Higher','TOV "ASD"',1, CURRENT_TIMESTAMP),
       ('john_smith','Jogn', 'Smith', '1983-02-15',2,5,'Secondary','TOV "HNG',8,CURRENT_TIMESTAMP),
       ('helen|_dove','Helen', 'Dove', '1984-01-31',3,9, 'Incomplete higher','TOV "GTD"',14,CURRENT_TIMESTAMP),
       ('pola_cast','Pola', 'Cast', '1981-05-02', 4,11,'Higher','TOV "HGR"',13,CURRENT_TIMESTAMP),
       ('sofiya_shine','Sofiya', 'Shine', '1988-03-12', 1, 2, 'Higher','TOV "HGF"',10,CURRENT_TIMESTAMP),
       ('alex_craft','Alex', 'Craft', '1987-08-25',1, 3, 'Higher', 'TOV "LOK"',3,CURRENT_TIMESTAMP),
       ('paul_mix','Paul', 'Mix', '1979-10-02',2,4,'Secondary', 'TOV "GVC"', 7, CURRENT_TIMESTAMP),
       ('jane_adams','Jane', 'Adams', '1982-04-27', 1, 1, 'Higher', 'TOV "KLO"',15,CURRENT_TIMESTAMP),
       ('jessica_klein','Jessica', 'Klein', '1984-02-06',3, 8, 'Incomplete higher', 'TOV "LKJ"',14, CURRENT_TIMESTAMP),
       ('vlad_kost','Vlad', 'Kost', '1989-07-23', 1,3, 'Higher', 'TOV "DSA"',3, CURRENT_TIMESTAMP),
       ('igor_medis','Igor', 'Medis', '1980-03-30',2, 5, 'Higher', 'TOV "YUI"',9, CURRENT_TIMESTAMP),
       ('lilu_mask', 'Lilu', 'Mask', '1995-05-25', 1, 2, 'Incomplete higher','TOV "MNB"',4,CURRENT_TIMESTAMP),
       ('paul_smith', 'Paul', 'Smith', '1987-01-03',2,4, 'Higher', 'TOV "DSA"', 1,CURRENT_TIMESTAMP),
       ('max_bill', 'Max', 'Bill', '1990-04-27',1, 2, 'Higher','TOV "JKL"', 9,CURRENT_TIMESTAMP);

insert into messages (sender_ID, message_text, recipient_ID,creation_date_message)
values (1, 'Hi, Paul. How are you?',7, CURRENT_TIMESTAMP),
       (7, 'Hi, Max. I am fine', 1, CURRENT_TIMESTAMP),
       (4, 'Good morning. I"d like to offer you a job',8,CURRENT_TIMESTAMP),
       (8, 'Good morning. Thank you, but I"m not interested in a new offers right now',4,CURRENT_TIMESTAMP),
       (4, 'Good morning. I"d like to offer you a job', 12,CURRENT_TIMESTAMP),
       (12, 'I"m interested in your offer',4,CURRENT_TIMESTAMP),
       (4, 'I invite you for an interview tomorrow',12,CURRENT_TIMESTAMP),
       (5,'Hello. Can you help me with current project?',14,CURRENT_TIMESTAMP),
       (14, 'I"m busy now. I"ll help you later',5,CURRENT_TIMESTAMP),
       (2,'Hi, I"m going to go to the cinema next Saturday. Let"s go together',5,CURRENT_TIMESTAMP),
       (5, 'Hi, ok. At what time?', 2,CURRENT_TIMESTAMP),
       (2,'At 5 p.m.',5,CURRENT_TIMESTAMP);

insert into posts (sender_ID, post_text, creation_date_post)
values (1,'Water is the source of all life. No plant, animal or human can live without it. Researchers say water is important for us to live longer. They say people who drink a lot of water every day are healthier. They live longer than people who do not drink a lot of water. People who drink a lot get fewer health problems and old-age illnesses, like heart and lung disease. Adults who do not drink enough water are more likely to die younger, and to get old quicker.
          Researchers looked at data from 11,000 hospital patients over 30 years. The patients had visited a hospital at least five times – three times in their 50s, and twice aged between 70 and 90. A researcher said: "Proper [water drinking] may slow down ageing and prolong a disease-free life." People should drink more water, juice, and fruit and vegetables with water in them. Half of people worldwide do not drink enough. An adult needs over 1.5 litres of water every day.',CURRENT_TIMESTAMP),
       (5,'Eating late at night is bad for us. It could make us sick. A new study says eating before bedtime increases the risk of obesity. Researchers looked into why eating late increased the risk of weight gain. Eating late makes us feel two times hungrier, so we eat more. When we eat earlier, we are less hungry, so we eat less food. Later eaters also eat unhealthier food. They also move around less before sleeping, so they do not burn off calories.
          Researchers looked at the eating habits of 16 people aged between 25 and 59. They were all overweight or obese, but were healthy. They ate regularly and exercised a little. They did not drink coffee or alcohol, and they did not smoke, or take medicine or drugs. They kept a sleep diary so researchers knew their sleeping times. A researcher said the study is telling us that, "it probably really is beneficial to stop eating late into the night".',CURRENT_TIMESTAMP),
       (7,'Hollywood makes many movies about asteroids hitting and destroying Earth. NASA may soon be able to stop asteroids. It tested a spacecraft that could change the direction of an asteroid so it doesn"t hit Earth. It is called DART. It set off in November 2021 to crash into an asteroid. DART hit the centre of the asteroid at 24,000 kph. Scientists do not know if they have changed the asteroid"s direction. They will find out in a few weeks when they get data.
          NASA said DART was the first of many "planetary protection missions". It joked about the death of the dinosaurs. It said: "We want to have a better chance than the dinosaurs had 65 million years ago." It added that all the dinosaurs could do was to "look up and say, "Oh asteroid"". NASA also said DART was a "new era for humankind". It said we could "protect ourselves from something like a dangerous, hazardous asteroid impact".',CURRENT_TIMESTAMP),
       (9,'Some people are forgetful, while others remember everything. Scientists know how the brain remembers things. There is little research on how it forgets things. Researchers in the USA studied how the brain forgets. The research may help people with memory problems. It may also help people who have depression and dementia. A researcher said: "It may sound surprising that people can control what and how they forget."
          The researcher said forgetting was important to keep the brain working smoothly. She said we can remove information from our minds. This is lets us focus on important tasks. We can control what we forget, but the act of forgetting needs a lot of effort. Another researcher said forgetting unimportant information is useful. Researchers will now look at why we forget simple things like where we left our keys.',CURRENT_TIMESTAMP),
       (10,'Air pollution can change our brain. A study shows how car fumes change how parts of our brain connect with other parts. The research found that car fumes changed our brain"s connectivity in two hours. A researcher was surprised by his research. He said: "For many decades, scientists thought the brain may be protected from the harmful effects of air pollution." He said his study shows there is a connection between air pollution and thinking.
           The study was on 25 adults. They breathed car fumes in a laboratory. Scientists took brain scans of the adults for two hours. The scans showed that the thinking networks in the brain changed. There were fewer connections between the networks. Another professor was worried by how traffic pollution changed the networks. She said people should close car windows when in traffic. The brains of the 25 people were OK after they breathed clean air.',CURRENT_TIMESTAMP),
       (13,'Cars and factories create lots of greenhouse gas. Cows, deer and goats also create gasses. A lot of the world"s methane comes from farm animals. Methane is the second most common greenhouse gas. Billionaire Bill Gates wants to cut methane from farm animals. He put money into a technology start-up called Rumin8. It has created a seaweed-based supplement. It says this will reduce the methane in animals" burps.',CURRENT_TIMESTAMP),
       (2,'We all like birthdays. Some of us have 120 of them. The world"s oldest land animal just had his 190th birthday. It is a giant turtle called Jonathan, who was born in 1832. Some scientists think Jonathan might be ten years older. He could be 200 years old. Jonathan was born in the Seychelles. He was born before Britain"s Queen Victoria became queen, and before the invention of the postage stamp and the *.
          Jonathan had a good birthday. He had a three-day party, with a special tortoise birthday cake full of his favourite vegetables. Sadly, Jonathan did not get to see anything because he is blind. He also cannot smell. However, his ears are OK, so he could hear "Happy Birthday" being sung. Also, he still has plenty of energy. He also likes to relax in the sun.'
           'His vet said: "On mild days, he will sunbathe – his long neck and legs stretched fully out of his shell."',CURRENT_TIMESTAMP);
