INSERT INTO `heap`.`address`
(
    `city`,
    `number`,
    `street`,
    `zip_code`)
VALUES
(
    "Nantes",
    10,
    "rue de la paix",
    44300
),
(
    "Nantes",
    5,
    "rue des martyres",
    44300
),
(
    "Nantes",
    8,
    "avenue des champs elysées",
    44300
),
(
    "Vannes",
    55,
    "boulevard de la mer",
    56000
),
(
    "Vannes",
    10,
    "avenue de Provence",
    56000
),
(
    "Vannes",
    32,
    "rue Sébastopol",
    56000
),
(
    "Angers",
    32,
    "Chemin Des Bateliers",
    49000
),
(
    "Angers",
    11,
    "rue des mouettes",
    49000
),
(
    "Angers",
    25,
    "avenue Ferdinand de Lesseps",
    49000
),
(
    "Lyon",
    28,
    "rue de la République",
    69000
),
(
    "Lyon",
    2,
    "rue Banaudon",
    69000
),
(
    "Lyon",
    105,
    "rue Rossini",
    69000
),
(
    "Lyon",
    41,
    "cours Jean Jaurès",
    69000
),
(
    "Lyon",
    100,
    "rue Rossini",
    69000
),
(
    "Nantes",
    63,
    "rue de la paix",
    44300
),
(
    "Vannes",
    5,
    "avenue de Provence",
    56000
),
(
    "Vannes",
    89,
    "boulevard de la mer",
    56000
),
(
    "Angers",
    80,
    "rue des mouettes",
    49000
),
(
    "Angers",
    13,
    "rue des mouettes",
    49000
);

INSERT INTO `heap`.`client`
(
    `civility`,
    `email`,
    `enabled`,
    `first_name`,
    `last_name`,
    `locked`,
    `password`,
    `role`,
    `person_address_id`)
VALUES
(
    "Monsieur",
    "admin@admin.com",
    true,
    "root",
    "admin",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "ADMIN",
    null
),
(
    "Monsieur",
    "grm@gmail.com",
    true,
    "Rom",
    "Grm",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "PARTICULIER",
    1
),
(
    "Monsieur",
    "yann@gmail.com",
    true,
    "Yann",
    "Lajd",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "PARTICULIER",
    2
),
(
    "Monsieur",
    "ablache@gmail.com",
    true,
    "Alex",
    "Blache",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "PARTICULIER",
    3
),
(
    "Monsieur",
    "trytry@gmail.com",
    true,
    "Trystan",
    "Valentin",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "PARTICULIER",
    4
),
(
    "Monsieur",
    "amin@gmail.com",
    true,
    "Amin",
    "Sehla",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "PARTICULIER",
    5
);

INSERT INTO `heap`.`shop`
(
    `civility`,
    `email`,
    `enabled`,
    `first_name`,
    `last_name`,
    `locked`,
    `password`,
    `role`,
    `activity_type`,
    `company_name`,
    `siret`,
    `person_shop_address_id`,
    `store_address_id`)
VALUES
(
    "Monsieur",
    "dinimu@gmail.com",
    true,
    "Tony",
    "Montana",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "PRO",
    "Barbier",
    "Barbapapa",
    54542125457825,
    6,
    7
),
(
    "Madame",
    "clairechaz@gmail.com",
    true,
    "Claire",
    "Chardon",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "PRO",
    "Estheticienne",
    "O'poil'",
    59542125457875,
    8,
    9
),
(
    "Monsieur",
    "jacquesfrere@gmail.com",
    true,
    "Jacques",
    "Frère",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "PRO",
    "Coiffeur",
    "La Tonsure",
    54792125457875,
    10,
    11
),
(
    "Monsieur",
    "brucewillis@gmail.com",
    true,
    "Bruce",
    "Wallas",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "PRO",
    "Masseur",
    "Relax Max",
    54542175457875,
    12,
    13
),
(
    "Madame",
    "emilieperret@gmail.com",
    true,
    "Emilie",
    "Perret",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "PRO",
    "Estheticienne",
    "LaBelle",
    54562125457875,
    14,
    15
),
(
    "Madame",
    "berenicemorin@gmail.com",
    true,
    "Bérénice",
    "Morin",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "PRO",
    "Bar_a_Ongles",
    "Affaire d'ongle",
    54542125457875,
    16,
    17
),
(
    "Monsieur",
    "Alfredriand@gmail.com",
    true,
    "Alfred",
    "Riand",
    false,
    "$2a$10$o9pRf0sT.TXva1afxBBofOND/ifcNK5E13vUmCxsy9q4c.KwuM/2W",
    "PRO",
    "Spa",
    "Spartacus",
    54542186457875,
    18,
    19
);

INSERT INTO `heap`.`collaborator`
(
    `firstname`,
    `shop_id`
)
VALUES
(
    "Marc",
    1
),
(
    "Marie",
    1
),
(
    "Elodie",
    1
),
(
    "Steve",
    1
),
(
    "Carole",
    1
),
(
    "François",
    2
),
(
    "Dominique",
    2
),
(
    "Louise",
    2
),
(
    "Yann",
    2
),
(
    "Caroline",
    2
),
(
    "Julien",
    3
),
(
    "Rémi",
    3
),
(
    "Frédérique",
    3
),
(
    "Emeline",
    3
),
(
    "Julien",
    4
),
(
    "Rémi",
    4
),
(
    "Frédérique",
    4
),
(
    "Emeline",
    4
),
(
    "Jeremy",
    5
),
(
    "Quentin",
    5
),
(
    "Amélie",
    5
),
(
    "Lucie",
    5
),
(
    "Franck",
    6
),
(
    "Laura",
    6
),
(
    "Leo",
    6
),
(
    "Miriam",
    6
),
(
    "Amin",
    7
),
(
    "Edouard",
    7
),
(
    "Délphine",
    7
),
(
    "Julie",
    7
);

INSERT INTO `heap`.`prestation`
(
    `description`,
    `duration`,
    `name`,
    `price`,
    `shop_id`
)
VALUES
(
    'Pour barbe longue',
    '15',
    'Barbe Dandy',
    '20',
    1
),
(
    'Pour Barbe courte',
    '15',
    'Barbe Voyou ',
    '80',
    1
),
(
    'Epilation du maillot',
    '10',
    'Epilation maillot ',
    '20',
    2
),
(
    'Epilation de la moustache',
    '10',
    'Epilation moustache',
    '10',
    2
),
(
    'Epilation des Jambes',
    '30',
    'Epilation Jambes ',
    '30',
    2
),
(
    'Coupe Homme au choix',
    '20',
    'Coupe homme ',
    '25',
    3
),
(
    'Ayurvedic',
    '60',
    'Massage relaxant ',
    '80',
    4
),
(
    'Tui-Na',
    '60',
    'Massage Tonifiant ',
    '70',
    4
),
(
    'Epilation du maillot',
    '10',
    'Epilation maillot ',
    '25',
    5
),
(
    'Epilation de la moustache',
    '10',
    'Epilation moustache',
    '15',
    5
),
(
    'Epilation des Jambes',
    '30',
    'Epilation Jambes ',
    '35',
    5
),
(
    'La manucure française consiste à appliquer un trait de vernis blanc opaque sur le bord de l ongle afin de le faire paraitre plus long.',
    '40',
    'French Manucure',
    '35',
    6
),
(
    'Décoration fun',
    '40',
    'Funny',
    '40',
    6
),
(
    'accès à 3 sauna (60°,70°,80°) et 2 hammam',
    '30',
    'sauna et hammam',
    '10',
    7
),
(
    'Sauna, Hammam, Bassin, pierres chaudes, jacuzzi',
    '90',
    'Full access',
    '15',
    7
);

INSERT INTO `heap`.`appointment`
(
    `date`,
    `start`,
    `client_id`,
    `collaborator_id`,
    `prestation_id`,
    `shop_id`
)
VALUES
(
    '2021-01-01 11:58:15',
    '2021-01-02 14:00:00',
    1,
    1,
    1,
    1
),
(
    '2021-01-01 11:58:15',
    '2021-01-02 14:00:00',
    2,
    2,
    2,
    2
),
(
    '2021-01-01 11:58:15',
    '2021-01-02 14:00:00',
    3,
    2,
    1,
    3
),
(
    '2021-01-01 11:58:15',
    '2021-01-02 14:00:00',
    4,
    3,
    2,
    4
),
(
    '2021-01-01 11:58:15',
    '2021-01-02 14:00:00',
    5,
    4,
    2,
    5
),
(
    '2021-01-03 11:58:15',
    '2021-01-04 14:00:00',
    4,
    1,
    1,
    6
),
(
    '2021-01-05 11:58:15',
    '2021-01-07 14:00:00',
    3,
    1,
    3,
    7
),
(
    '2021-01-08 11:58:15',
    '2021-01-09 14:00:00',
    2,
    2,
    2,
    3
),
(
    '2021-01-10 11:58:15',
    '2021-01-11 14:00:00',
    1,
    1,
    1,
    1
),
(
    '2021-01-25 11:58:15',
    '2021-01-28 14:00:00',
    5,
    4,
    2,
    6
);






