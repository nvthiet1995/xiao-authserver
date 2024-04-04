INSERT INTO
  `users` (
    `username`,
    `password`,
    `email_address`,
    `created_at`,
    `created_by`
  )
VALUES
  (
    'danh',
    '$2a$12$xj1L/pFygtuvYNqyIlH7BOlY74QdpRSQ.XM.HmrhAKBAr/GXljBJS',
    'danh@gmail.com',
    STR_TO_DATE('04-04-2024 09:33:15', '%d-%m-%Y %H:%i:%s'),
    'flyway'
  );