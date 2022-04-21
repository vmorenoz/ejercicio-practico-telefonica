DO
$do$
    BEGIN
        FOR i IN 1..100
            LOOP
                INSERT INTO customer
                    (full_name, document_type, document_number, birthday_date, updated_at)
                VALUES (concat('Test ', i::text), floor(random() * (2 - 1 + 1) + 1), lpad(i::text, 8, '0'), now(),
                        null);
            END LOOP;
    END
$do$;