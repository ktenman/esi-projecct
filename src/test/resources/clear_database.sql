CREATE OR REPLACE FUNCTION truncate_all_tables_except_for_liquibase()
    RETURNS VOID
AS
'
    DECLARE
        table_record RECORD;
    BEGIN
        FOR table_record IN SELECT *
                            FROM information_schema.tables
                            WHERE table_schema = ''public''
                              AND table_type = ''BASE TABLE''
            LOOP
                IF table_record.table_name != ''databasechangelog''
                    AND table_record.table_name != ''databasechangeloglock''
                    AND table_record.table_name != ''authority''
                THEN
                    EXECUTE FORMAT(''TRUNCATE TABLE %I CASCADE'', table_record.table_name);
                END IF;
            END LOOP;
    END;
'
    LANGUAGE plpgsql;

SELECT truncate_all_tables_except_for_liquibase();
