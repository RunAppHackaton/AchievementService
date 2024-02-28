insert into goal_status(goal_status_name)
values ('IN_PROGRESS');

insert into goal_status(goal_status_name)
values ('FINISHED');

insert into goal_type(goal_type_name)
values ('TOTAL_TRAINING_TIME');

insert into goal_type(goal_type_name)
values ('AVERAGE_RUNNING_PACE');

insert into goal_type(goal_type_name)
values ('TOTAL_NUMBER_OF_WORKOUTS_IN_WEEK');

insert into goal_type(goal_type_name)
values ('TOTAL_NUMBER_OF_WORKOUTS_IN_MONTH');

insert into goal_type(goal_type_name)
values ('TOTAL_NUMBER_OF_WORKOUTS_IN_YEAR');

insert into goal_type(goal_type_name)
values ('TOTAL_NUMBER_OF_WORKOUTS_IN_ALL_TIME');

insert into goal_type(goal_type_name)
values ('TOTAL_KILOMETERS');
--rarities
insert into rarity_model (name) values ('Common');
insert into rarity_model (name) values ('Rare');
insert into rarity_model (name) values ('Epic');
insert into rarity_model (name) values ('Legendary');
--run a certain amount of kilometers for all the time
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
            'Endurance Champion 1',
            1,
            'Unlocked by consistently completing 10-kilometer runs, showcasing exceptional endurance and dedication to long-distance running. Your commitment to pushing through the challenges of each run demonstrates remarkable perseverance and fitness prowess.',
            'https://storage.cloud.google.com/run-app-bucket/achievement-images/common.jpg?authuser=3',
            1
       );
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
           'Endurance Champion 2',
           1,
           'Unlocked by consistently completing 100-kilometer runs, showcasing exceptional endurance and dedication to long-distance running. Your commitment to pushing through the challenges of each run demonstrates remarkable perseverance and fitness prowess.',
           'https://storage.cloud.google.com/run-app-bucket/achievement-images/rare.jpg?authuser=3',
           2
       );
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
           'Endurance Champion 3',
           1,
           'Unlocked by consistently completing 500-kilometer runs, showcasing exceptional endurance and dedication to long-distance running. Your commitment to pushing through the challenges of each run demonstrates remarkable perseverance and fitness prowess.',
           'https://storage.cloud.google.com/run-app-bucket/achievement-images/epic.jpg?authuser=3',
           3
       );
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
           'Endurance Champion 4',
           1,
           'Unlocked by consistently completing 1000-kilometer runs, showcasing exceptional endurance and dedication to long-distance running. Your commitment to pushing through the challenges of each run demonstrates remarkable perseverance and fitness prowess.',
           'https://storage.cloud.google.com/run-app-bucket/achievement-images/epic.jpg?authuser=3',
           3
       );
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
           'Endurance Champion 5',
           1,
           'Unlocked by consistently completing 2500-kilometer runs, showcasing exceptional endurance and dedication to long-distance running. Your commitment to pushing through the challenges of each run demonstrates remarkable perseverance and fitness prowess.',
           'https://storage.cloud.google.com/run-app-bucket/achievement-images/legendary.jpg?authuser=3',
           4
       );
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
           'Endurance Champion 6',
           1,
           'Unlocked by consistently completing 5000-kilometer runs, showcasing exceptional endurance and dedication to long-distance running. Your commitment to pushing through the challenges of each run demonstrates remarkable perseverance and fitness prowess.',
           'https://storage.cloud.google.com/run-app-bucket/achievement-images/legendary.jpg?authuser=3',
           4
       );
--run a certain amount of kilometers for a single day
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
           'Marathon Maverick 1',
           1,
           'Earned by completing a 10-kilometer run in a single day, showcasing exceptional endurance and determination. Your commitment to pushing your physical limits demonstrates remarkable perseverance and a dedication to maintaining a healthy lifestyle.',
           'https://storage.cloud.google.com/run-app-bucket/achievement-images/rare.jpg?authuser=3',
           2
       );
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
           'Marathon Maverick 2',
           1,
           'Earned by completing a 20-kilometer run in a single day, showcasing exceptional endurance and determination. Your commitment to pushing your physical limits demonstrates remarkable perseverance and a dedication to maintaining a healthy lifestyle.',
           'https://storage.cloud.google.com/run-app-bucket/achievement-images/rare.jpg?authuser=3',
           2
       );
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
           'Marathon Maverick 3',
           1,
           'Earned by completing a 30-kilometer run in a single day, showcasing exceptional endurance and determination. Your commitment to pushing your physical limits demonstrates remarkable perseverance and a dedication to maintaining a healthy lifestyle.',
           'https://storage.cloud.google.com/run-app-bucket/achievement-images/rare.jpg?authuser=3',
           2
       );
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
           'Marathon Maverick 4',
           1,
           'Earned by completing a 40-kilometer run in a single day, showcasing exceptional endurance and determination. Your commitment to pushing your physical limits demonstrates remarkable perseverance and a dedication to maintaining a healthy lifestyle.',
           'https://storage.cloud.google.com/run-app-bucket/achievement-images/rare.jpg?authuser=3',
           2
       );
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
           'Marathon Maverick 5',
           1,
           'Earned by completing a 50-kilometer run in a single day, showcasing exceptional endurance and determination. Your commitment to pushing your physical limits demonstrates remarkable perseverance and a dedication to maintaining a healthy lifestyle.',
           'https://storage.cloud.google.com/run-app-bucket/achievement-images/rare.jpg?authuser=3',
           2
       );
--follow a program of training for a certain period of time
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
           'Steadfast Strider',
           1,
           'Awarded for consistently following a running program for a month, demonstrating unwavering dedication and commitment to personal fitness goals. Your perseverance in adhering to the program showcases resilience and determination',
           'https://storage.cloud.google.com/run-app-bucket/achievement-images/epic.jpg?authuser=3',
           3
       );
insert into achievement (name, story_id, description, achievement_image_url, rarity_id)
values (
           'Yearlong Runner',
           1,
           'Awarded for consistently adhering to a running program for an entire year, showcasing dedication, perseverance, and commitment to fitness. Your effort and discipline have led to significant improvements in endurance, health, and overall well-being.',
           'https://storage.cloud.google.com/run-app-bucket/achievement-images/legendary.jpg?authuser=3',
           4
       );

