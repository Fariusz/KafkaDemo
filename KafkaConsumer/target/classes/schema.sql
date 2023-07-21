CREATE TABLE IF NOT EXISTS message (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     topic VARCHAR(400) NOT NULL,
                                     content VARCHAR(2000) NOT NULL
);
