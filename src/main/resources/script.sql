DROP TABLE EMPRESA;

CREATE TABLE IF NOT EXISTS empresa (id INT PRIMARY KEY, nome varchar(20), data_criacao timestamp);

CREATE DEFINER=`user_cache`@`localhost` FUNCTION `populaDB`() RETURNS int
    DETERMINISTIC
BEGIN
	DECLARE	v_counter INT;
	DECLARE	registros INT;
	DECLARE	v_max INT;
    set v_max = 300000;
    SET v_counter=1;
    set registros=0;

	set registros = (select COUNT(*) FROM empresa limit 10);

	IF registros = 0 THEN

		while v_counter <= v_max do
			INSERT INTO empresa (id, nome, data_criacao)
			VALUES (v_counter, CONCAT('Empresa ', v_counter), now());

			set v_counter=v_counter+1;
        end while;

    END IF;

    return 0;

END;

select populaDb();

SELECT * FROM empresa limit 10;