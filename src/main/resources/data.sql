TRUNCATE TABLE usuarios RESTART IDENTITY;

INSERT INTO usuarios (cpf, nome, nascimento, email) VALUES
    ('789.456.132-25', 'Maria', DATE '2000-10-15', 'maria@mail.com'),
    ('123.456.789-10', 'Joao', DATE '1998-04-21', 'joao@mail.com'),
    ('987.654.321-00', 'Ricardo', DATE '1995-07-09', 'ricardo@mail.com'),
    ('456.789.123-99', 'Priscila', DATE '2001-01-30', 'priscila@mail.com'),
    ('321.654.987-11', 'Ana', DATE '1992-11-03', 'ana.souza@mail.com'),
    ('654.987.321-22', 'Carlos', DATE '1989-06-17', 'carlos.lima@mail.com'),
    ('147.258.369-33', 'Fernanda', DATE '1997-09-12', 'fernanda.alves@mail.com'),
    ('258.369.147-44', 'Lucas', DATE '1994-02-25', 'lucas.costa@mail.com'),
    ('369.147.258-55', 'Camila', DATE '1999-08-08', 'camila.oliveira@mail.com'),
    ('741.852.963-66', 'Bruno', DATE '1993-12-19', 'bruno.pereira@mail.com');
