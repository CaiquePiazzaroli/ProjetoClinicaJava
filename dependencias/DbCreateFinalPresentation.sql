-- drop database clinica;
create database clinica; 
use clinica;

-- O trecho abaixo cria a tabela usuarios do sistema
create table usuarios (
	idUsuario integer auto_increment,
    nomeUsuario varchar(32) not null,
    login varchar(32) not null,
    senha varchar(32) not null,
    tipoUsuario varchar(32) not null,
	primary key(idUsuario)
);

-- Inserindo resgistros na tabela usuarios
insert into usuarios (nomeUsuario, login, senha, tipoUsuario) values
('Caique Piazzaroli', 'caique','1234','admin'),
('Linus Torvalds','Linus','linux','user');

-- Visualizando os dados da tabela usuarios
select * from usuarios;

-- O trecho abaixo cria a tabela Pacientes 
create table pacientes (
	idPaciente int auto_increment primary key,
    nomePaciente varchar(100) not null,
    dataNascimento date not null,
    rg varchar(9) not null,
    altura varchar(6),
    peso  varchar(6) ,
    sexo varchar(10) not null,
    telefone varchar(14),
    cel varchar(14),
	idConvenio varchar (32) not null
);


-- Insert na tabela pacientes
INSERT INTO pacientes (
    nomePaciente, dataNascimento, rg, altura, peso, sexo, telefone, cel, idConvenio
) VALUES 
('João Silva', '1979-04-15', '123456789', '1.75', '80', 'Masculino', '1234-5678', '91234-5678', 'CONV001'),
('Maria Oliveira', '1962-11-20', '234567890', '1.60', '65', 'Feminino', '2345-6789', '92345-6789', 'CONV002'),
('Carlos Pereira', '1971-07-05', '345678901', '1.80', '90', 'Masculino', '3456-7890', '93456-7890', 'CONV003'),
('Ana Ferreira', '1987-03-25', '456789012', '1.70', '70', 'Feminino', '4567-8901', '94567-8901', 'CONV004'),
('Pedro Souza', '1965-08-15', '567890123', '1.85', '85', 'Masculino', '5678-9012', '95678-9012', 'CONV005'),
('Lucas Mendes', '1974-12-30', '678901234', '1.78', '82', 'Masculino', '6789-0123', '96789-0123', 'CONV006'),
('Mariana Silva', '1977-09-12', '789012345', '1.65', '68', 'Feminino', '7890-1234', '97890-1234', 'CONV007'),
('Rafael Costa', '1964-05-22', '890123456', '1.77', '78', 'Masculino', '8901-2345', '98901-2345', 'CONV008'),
('Carla Souza', '1985-10-10', '901234567', '1.68', '72', 'Feminino', '9012-3456', '99012-3456', 'CONV009'),
('Fábio Pereira', '1969-02-17', '012345678', '1.82', '88', 'Masculino', '0123-4567', '90123-4567', 'CONV010'),
('José Almeida', '1972-06-08', '112233445', '1.76', '79', 'Masculino', '1122-3344', '91122-3344', 'CONV011'),
('Clara Nunes', '1979-11-21', '223344556', '1.64', '66', 'Feminino', '2233-4455', '92233-4455', 'CONV012'),
('Ricardo Souza', '1963-08-19', '334455667', '1.81', '89', 'Masculino', '3344-5566', '93344-5566', 'CONV013'),
('Fernanda Castro', '1985-01-07', '445566778', '1.67', '73', 'Feminino', '4455-6677', '94455-6677', 'CONV014'),
('Bruno Lima', '1969-03-28', '556677889', '1.83', '87', 'Masculino', '5566-7788', '95566-7788', 'CONV015'),
('Aline Silva', '1974-07-16', '667788990', '1.74', '75', 'Feminino', '6677-8899', '96677-8899', 'CONV016'),
('Gustavo Lima', '1982-04-03', '778899001', '1.80', '85', 'Masculino', '7788-9900', '97788-9900', 'CONV017'),
('Isabela Moura', '1989-11-30', '889900112', '1.63', '60', 'Feminino', '8899-0011', '98899-0011', 'CONV018'),
('Lucas Rocha', '1976-02-14', '990011223', '1.75', '83', 'Masculino', '9900-1122', '99900-1122', 'CONV019'),
('Fernanda Souza', '1964-09-27', '001122334', '1.66', '70', 'Feminino', '0011-2233', '90011-2233', 'CONV020');

-- Criado a tabela profissional e especialidade profissional
create table profissionais(
	idProfissional integer auto_increment,
    nomeProfissional varchar(62) not null,
    primary key (idProfissional)
);

-- insert profissionais 
INSERT INTO profissionais (nomeProfissional) VALUES
('Dr. Roberto Costa'),
('Dra. Ana Paula Mendes'),
('Dr. Eduardo Lima'),
('Dr. Marcos Silva'),
('Dra. Juliana Torres'),
('Dr. Carlos Moreira'),
('Dra. Fernanda Lima'),
('Dr. Henrique Almeida'),
('Dra. Paula Santos'),
('Dr. Leonardo Nunes'),
('Dr. Ricardo Martins'),
('Dra. Luisa Fernandes'),
('Dr. Marcelo Alves'),
('Dra. Camila Oliveira'),
('Dr. João Rodrigues'),
('Dr. Fernando Costa'),
('Dra. Juliana Santos'),
('Dr. Ricardo Alves'),
('Dra. Mariana Oliveira'),
('Dr. Paulo Mendes');


-- visualizando profissional cadastrado 
select * from profissionais;

-- 
/*create table especialidadeProfissional(
    idProfissional integer not null,
	nomeEspecialidade varchar(62) not null,
    CONSTRAINT idEspecialidade PRIMARY KEY (idProfissional, nomeEspecialidade),
    foreign key(idProfissional) references profissionais(idProfissional)
); */

-- Criando a tabela dos horarios em que o profissional atende
create table horarioProfissional (
	idProfissional integer not null,
	nomeEspecialidade varchar(62) not null,
	diaSemana varchar(32) not null,
    horaInicio time,
    horaFim time,
    CONSTRAINT idHorario PRIMARY KEY (idProfissional, diaSemana),
    foreign key(idProfissional) references profissionais(idProfissional)
);

-- Insert horario progissional
INSERT INTO horarioProfissional (idProfissional, nomeEspecialidade, diaSemana, horaInicio, horaFim) VALUES
(1, 'Ecocardiograma', 'Segunda-feira', '08:00:00', '12:00:00'),
(1, 'Eletrocardiograma', 'Quarta-feira', '14:00:00', '18:00:00'),
(2, 'Ecocardiograma', 'Terça-feira', '09:00:00', '13:00:00'),
(2, 'Ergometrico', 'Quinta-feira', '15:00:00', '19:00:00'),
(3, 'Holter 24', 'Segunda-feira', '10:00:00', '14:00:00'),
(3, 'Eletrocardiograma', 'Sexta-feira', '08:00:00', '12:00:00'),
(4, 'Ecocardiograma', 'Quarta-feira', '11:00:00', '15:00:00'),
(4, 'Ergometrico', 'Sexta-feira', '14:00:00', '18:00:00'),
(5, 'Holter 24', 'Terça-feira', '08:00:00', '12:00:00'),
(5, 'Eletrocardiograma', 'Quinta-feira', '13:00:00', '17:00:00'),
(6, 'Ecocardiograma', 'Segunda-feira', '09:00:00', '13:00:00'),
(6, 'Ergometrico', 'Quarta-feira', '08:00:00', '12:00:00'),
(7, 'Ecocardiograma', 'Terça-feira', '10:00:00', '14:00:00'),
(7, 'Holter 24', 'Quinta-feira', '09:00:00', '13:00:00'),
(8, 'Eletrocardiograma', 'Sexta-feira', '10:00:00', '14:00:00'),
(8, 'Ergometrico', 'Segunda-feira', '14:00:00', '18:00:00'),
(9, 'Ergometrico', 'Quarta-feira', '09:00:00', '13:00:00'),
(9, 'Ecocardiograma', 'Sexta-feira', '08:00:00', '12:00:00'),
(10, 'Holter 24', 'Terça-feira', '14:00:00', '18:00:00'),
(10, 'Eletrocardiograma', 'Quinta-feira', '10:00:00', '14:00:00'),
(11, 'Holter 24', 'Segunda-feira', '08:00:00', '12:00:00'),
(11, 'Ecocardiograma', 'Quarta-feira', '14:00:00', '18:00:00'),
(12, 'Holter 24', 'Terça-feira', '09:00:00', '13:00:00'),
(12, 'Ergometrico', 'Quinta-feira', '15:00:00', '19:00:00'),
(13, 'Ergometrico', 'Segunda-feira', '10:00:00', '14:00:00'),
(13, 'Eletrocardiograma', 'Sexta-feira', '08:00:00', '12:00:00'),
(14, 'Holter 24', 'Quarta-feira', '11:00:00', '15:00:00'),
(14, 'Ecocardiograma', 'Sexta-feira', '14:00:00', '18:00:00'),
(15, 'Ergometrico', 'Terça-feira', '08:00:00', '12:00:00'),
(15, 'Holter 24', 'Quinta-feira', '13:00:00', '17:00:00'),
(16, 'Eletrocardiograma', 'Segunda-feira', '09:00:00', '13:00:00'),
(16, 'Holter 24', 'Quarta-feira', '08:00:00', '12:00:00'),
(17, 'Ecocardiograma', 'Terça-feira', '10:00:00', '14:00:00'),
(17, 'Ergometrico', 'Quinta-feira', '09:00:00', '13:00:00'),
(18, 'Eletrocardiograma', 'Sexta-feira', '10:00:00', '14:00:00'),
(18, 'Holter 24', 'Segunda-feira', '14:00:00', '18:00:00'),
(19, 'Ergometrico', 'Quarta-feira', '09:00:00', '13:00:00'),
(19, 'Eletrocardiograma', 'Sexta-feira', '08:00:00', '12:00:00'),
(20, 'Holter 24', 'Terça-feira', '14:00:00', '18:00:00'),
(20, 'Ecocardiograma', 'Quinta-feira', '10:00:00', '14:00:00');





-- Criando a tabela dos agendamentos dos clientes
create table agendamentos(
	idAgendamento integer not null auto_increment primary key,
    nomePaciente varchar(62) not null,
    emailPaciente varchar(62) not null,
    telefonePaciente varchar(62),
    celularPaciente varchar(62) not null,
	nomeProfissional varchar(62) not null,
    dataRealizacao varchar(62) not null,
    horario varchar(62) not null,
    statusAgendamento varchar(62) not null,
    obsExames varchar(120) not null
);


-- insert agendamentos
INSERT INTO agendamentos (nomePaciente, emailPaciente, telefonePaciente, celularPaciente, nomeProfissional, dataRealizacao, horario, statusAgendamento, obsExames) VALUES
('João Silva', 'joao.silva@email.com', '1234-5678', '91234-5678', 'Dr. Roberto Costa', '2024-06-21', '09:00 - 10:00', 'Confirmado', 'Ecocardiograma'),
('Maria Oliveira', 'maria.oliveira@email.com', '2345-6789', '92345-6789', 'Dra. Ana Paula Mendes', '2024-06-22', '14:00 - 15:00', 'Confirmado', 'Eletrocardiograma'),
('Carlos Pereira', 'carlos.pereira@email.com', '3456-7890', '93456-7890', 'Dr. Eduardo Lima', '2024-06-23', '10:00 - 11:00', 'Cancelado', 'Holter 24'),
('Ana Ferreira', 'ana.ferreira@email.com', '4567-8901', '94567-8901', 'Dra. Juliana Torres', '2024-06-24', '15:00 - 16:00', 'Confirmado', 'Ergometrico'),
('Pedro Souza', 'pedro.souza@email.com', '5678-9012', '95678-9012', 'Dr. Marcos Silva', '2024-06-25', '08:00 - 09:00', 'Confirmado', 'Ecocardiograma e Eletrocardiograma'),
('Lucas Mendes', 'lucas.mendes@email.com', '6789-0123', '96789-0123', 'Dra. Fernanda Lima', '2024-06-26', '09:00 - 10:00', 'Confirmado', 'Holter 24'),
('Mariana Silva', 'mariana.silva@email.com', '7890-1234', '97890-1234', 'Dr. Henrique Almeida', '2024-06-27', '14:00 - 15:00', 'Confirmado', 'Ergometrico'),
('Rafael Costa', 'rafael.costa@email.com', '8901-2345', '98901-2345', 'Dra. Paula Santos', '2024-06-28', '11:00 - 12:00', 'Confirmado', 'Holter 24'),
('Carla Souza', 'carla.souza@email.com', '9012-3456', '99012-3456', 'Dr. Leonardo Nunes', '2024-06-29', '13:00 - 14:00', 'Confirmado', 'Eletrocardiograma'),
('Fábio Pereira', 'fabio.pereira@email.com', '0123-4567', '90123-4567', 'Dra. Luisa Fernandes', '2024-06-30', '08:00 - 09:00', 'Cancelado', 'Ecocardiograma'),
('José Almeida', 'jose.almeida@email.com', '1122-3344', '91122-3344', 'Dr. Marcelo Alves', '2024-07-01', '10:00 - 11:00', 'Confirmado', 'Ergometrico'),
('Clara Nunes', 'clara.nunes@email.com', '2233-4455', '92233-4455', 'Dra. Camila Oliveira', '2024-07-02', '15:00 - 16:00', 'Confirmado', 'Holter 24'),
('Ricardo Souza', 'ricardo.souza@email.com', '3344-5566', '93344-5566', 'Dr. João Rodrigues', '2024-07-03', '08:00 - 09:00', 'Confirmado', 'Eletrocardiograma'),
('Fernanda Castro', 'fernanda.castro@email.com', '4455-6677', '94455-6677', 'Dra. Juliana Santos', '2024-07-04', '14:00 - 15:00', 'Cancelado', 'Holter 24'),
('Bruno Lima', 'bruno.lima@email.com', '5566-7788', '95566-7788', 'Dr. Ricardo Alves', '2024-07-05', '11:00 - 12:00', 'Confirmado', 'Ergometrico'),
('Aline Silva', 'aline.silva@email.com', '6677-8899', '96677-8899', 'Dra. Mariana Oliveira', '2024-07-06', '10:00 - 11:00', 'Confirmado', 'Ecocardiograma'),
('Gustavo Lima', 'gustavo.lima@email.com', '7788-9900', '97788-9900', 'Dr. Fernando Costa', '2024-07-07', '13:00 - 14:00', 'Confirmado', 'Holter 24'),
('Isabela Moura', 'isabela.moura@email.com', '8899-0011', '98899-0011', 'Dra. Juliana Santos', '2024-07-08', '15:00 - 16:00', 'Confirmado', 'Eletrocardiograma'),
('Lucas Rocha', 'lucas.rocha@email.com', '9900-1122', '99900-1122', 'Dr. Paulo Mendes', '2024-07-09', '09:00 - 10:00', 'Confirmado', 'Holter 24'),
('Fernanda Souza', 'fernanda.souza@email.com', '0011-2233', '90011-2233', 'Dra. Camila Oliveira', '2024-07-10', '08:00 - 09:00', 'Cancelado', 'Ergometrico');




--
select * from agendamentos;

select idAgendamento as 'N° Agendamento', nomePaciente as 'Paciente', emailPaciente as 'Email', celularPaciente as 'Celular', nomeProfissional as 'Profissional Responsável', dataRealizacao as 'Data', 
horario as 'Horas', obsExames as 'Exames' from agendamentos;








-- Inserindo os horarios de atendimento para o profissional
insert into horarioProfissional (idProfissional, nomeEspecialidade, diaSemana, horaInicio, horaFim) values (1,"Holter 24", "Quarta", "09:00:00","14:00:00");


-- Verificando os horarios do profissional
select nomeEspecialidade, diaSemana, horaInicio, horaFim from horarioProfissional where idProfissional = 1;

-- funções para trabalhar com horas
select hour(current_time()) as hora_agora;
select minute(current_time()) as minuto_agora;
select timediff("2024-05-23 11:00:00","2024-05-23 11:00:00");
SET lc_time_names = 'pt_PT';
select dayname("2024-09-25");


-- Criando tabela Holter 24
CREATE table holter24 (
	idExame int auto_increment primary key,
    paciente varchar(62),
    idade int,
    profissional varchar(62),
	horarioExame varchar(62),
	dataExame varchar(62),
    idAgendamento varchar(10),
    freqMax varchar(32),
    freqMed varchar(32),
    freqMin varchar(32),
    totBat varchar(32),
	varRR varchar(32),
	extraVentr varchar(32),
    extraVentrPar varchar(32),
    tacVentr varchar(32),
    extraSupra varchar(32),
    tacSupra varchar(32),
    obsExame varchar(64)
);


-- select na tabela holter 24
select * from holter24;


-- Iserindo dados no holter24
INSERT INTO holter24 (
    paciente, idade, profissional, horarioExame, dataExame, idAgendamento, 
    freqMax, freqMed, freqMin, totBat, varRR, extraVentr, extraVentrPar, 
    tacVentr, extraSupra, tacSupra, obsExame
) VALUES 
('João Silva', 45, 'Dr. Roberto Costa', '14:00', '2024-06-18', 'AG123456', '180 bpm', '75 bpm', '60 bpm', '100000', '50 ms', '10', '2', '0', '5', '1', 'Paciente com poucas arritmias'),
('Maria Oliveira', 62, 'Dra. Ana Paula Mendes', '09:30', '2024-06-17', 'AG654321', '170 bpm', '80 bpm', '65 bpm', '95000', '60 ms', '5', '1', '1', '8', '2', 'Exame normal com algumas ectopias supraventriculares'),
('Carlos Pereira', 53, 'Dr. Eduardo Lima', '11:00', '2024-06-16', 'AG789012', '160 bpm', '70 bpm', '55 bpm', '98000', '45 ms', '8', '3', '2', '10', '0', 'Paciente com episódios de taquicardia ventricular'),
('Ana Ferreira', 37, 'Dr. Marcos Silva', '13:45', '2024-06-15', 'AG345678', '175 bpm', '78 bpm', '62 bpm', '92000', '55 ms', '12', '4', '0', '7', '3', 'Holter com arritmias ventriculares e supraventriculares'),
('Pedro Souza', 59, 'Dra. Juliana Torres', '10:15', '2024-06-14', 'AG890123', '168 bpm', '77 bpm', '63 bpm', '97000', '58 ms', '7', '2', '1', '9', '1', 'Exame com frequentes extra-sístoles ventriculares');


-- Criando tabela Ecocardiograma
CREATE table ecocardiograma (
	idExame int auto_increment primary key,
    paciente varchar(62),
    idade int,
    profissional varchar(62),
	horarioExame varchar(62),
	dataExame varchar(62),
    idAgendamento varchar(10),
    diaDiastolico varchar(62),
    diaSistolico varchar(62),
    espessuraDiastolicaSepto varchar(62),
    espessuraDiastolicaPar varchar(62),
    massaVentriculoEsquerdo varchar(62),
    diametroDiastolico varchar(62),
    diametroTelessistolico varchar(62),
    diametroAorta varchar(62),
    obsExame varchar(64)
);

-- Iserindo dados para ecocardiograma
INSERT INTO ecocardiograma (
    paciente, idade, profissional, horarioExame, dataExame, idAgendamento, 
    diaDiastolico, diaSistolico, espessuraDiastolicaSepto, espessuraDiastolicaPar, 
    massaVentriculoEsquerdo, diametroDiastolico, diametroTelessistolico, diametroAorta, obsExame
) VALUES 
('Lucas Mendes', 50, 'Dr. Carlos Moreira', '09:00', '2024-06-19', 'AG111111', '5.5 cm', '3.2 cm', '1.0 cm', '1.1 cm', '195 g', '4.8 cm', '2.9 cm', '3.1 cm', 'Ecocardiograma dentro dos padrões normais'),
('Mariana Silva', 47, 'Dra. Fernanda Lima', '10:30', '2024-06-19', 'AG222222', '5.7 cm', '3.3 cm', '1.1 cm', '1.0 cm', '205 g', '5.1 cm', '3.0 cm', '3.3 cm', 'Pequena hipertrofia ventricular esquerda'),
('Rafael Costa', 60, 'Dr. Henrique Almeida', '11:45', '2024-06-19', 'AG333333', '5.9 cm', '3.4 cm', '1.2 cm', '1.1 cm', '215 g', '5.2 cm', '3.1 cm', '3.4 cm', 'Hipertrofia ventricular esquerda moderada'),
('Carla Souza', 39, 'Dra. Paula Santos', '13:15', '2024-06-19', 'AG444444', '5.6 cm', '3.2 cm', '1.0 cm', '1.1 cm', '200 g', '5.0 cm', '3.0 cm', '3.2 cm', 'Ecocardiograma normal, sem alterações'),
('Fábio Pereira', 55, 'Dr. Leonardo Nunes', '14:30', '2024-06-19', 'AG555555', '6.0 cm', '3.5 cm', '1.3 cm', '1.2 cm', '220 g', '5.3 cm', '3.2 cm', '3.5 cm', 'Dilatação leve do ventrículo esquerdo');


-- Criando a tabela Ergométrico
CREATE table ergometrico (
	idExame int auto_increment primary key,
    paciente varchar(62),
    idade int,
    profissional varchar(62),
	horarioExame varchar(62),
	dataExame varchar(62),
    idAgendamento varchar(10),
    duracaoProva varchar(62),
    distanciaPercorrida varchar(62),
    fCMaxima varchar(62),
    debitoCardiaco varchar(62),
    debtoSistolico varchar(62),
    dPmaximo varchar(62),
    mETmaximo varchar(62),
    obsExame varchar(64)
);

-- Insert ergometrico 
INSERT INTO ergometrico (
    paciente, idade, profissional, horarioExame, dataExame, idAgendamento, 
    duracaoProva, distanciaPercorrida, fCMaxima, debitoCardiaco, debtoSistolico, 
    dPmaximo, mETmaximo, obsExame
) VALUES 
('José Almeida', 52, 'Dr. Ricardo Martins', '08:30', '2024-06-20', 'AG666666', '12 minutos', '1500 metros', '180 bpm', '14 L/min', '80 mL/latido', '30000', '10', 'Teste ergométrico normal'),
('Clara Nunes', 45, 'Dra. Luisa Fernandes', '09:45', '2024-06-20', 'AG777777', '15 minutos', '1700 metros', '175 bpm', '13 L/min', '75 mL/latido', '29500', '11', 'Teste ergométrico com boa capacidade aeróbica'),
('Ricardo Souza', 60, 'Dr. Marcelo Alves', '11:00', '2024-06-20', 'AG888888', '10 minutos', '1300 metros', '170 bpm', '12 L/min', '70 mL/latido', '28000', '9', 'Teste ergométrico com sinais de isquemia'),
('Fernanda Castro', 38, 'Dra. Camila Oliveira', '12:15', '2024-06-20', 'AG999999', '14 minutos', '1600 metros', '185 bpm', '15 L/min', '85 mL/latido', '31500', '12', 'Teste ergométrico excelente'),
('Bruno Lima', 55, 'Dr. João Rodrigues', '13:30', '2024-06-20', 'AG101010', '11 minutos', '1400 metros', '165 bpm', '11 L/min', '65 mL/latido', '27000', '8', 'Teste ergométrico com resposta hipertensiva');


-- Criando a tabela Eletrocardiograma
CREATE table eletrocardiograma (
	idExame int auto_increment primary key,
    paciente varchar(62),
    idade int,
    profissional varchar(62),
	horarioExame varchar(62),
	dataExame varchar(62),
    idAgendamento varchar(10),
    interpretacao varchar(120),
    obsExame varchar(64)
);


-- Insert eletrocardiogrmaa
INSERT INTO eletrocardiograma (
    paciente, idade, profissional, horarioExame, dataExame, idAgendamento, 
    interpretacao, obsExame
) VALUES 
('Aline Silva', 50, 'Dr. Fernando Costa', '08:00', '2024-06-21', 'AG112233', 'Ritmo sinusal, sem alterações significativas', 'Eletrocardiograma normal'),
('Gustavo Lima', 42, 'Dra. Juliana Santos', '09:15', '2024-06-21', 'AG223344', 'Ritmo sinusal, bradicardia sinusal', 'Bradicardia leve'),
('Isabela Moura', 35, 'Dr. Ricardo Alves', '10:30', '2024-06-21', 'AG334455', 'Ritmo sinusal, sinais de hipertrofia ventricular esquerda', 'Sinais de hipertrofia'),
('Lucas Rocha', 48, 'Dra. Mariana Oliveira', '11:45', '2024-06-21', 'AG445566', 'Ritmo sinusal, bloqueio de ramo direito', 'Bloqueio incompleto do ramo direito'),
('Fernanda Souza', 60, 'Dr. Paulo Mendes', '13:00', '2024-06-21', 'AG556677', 'Ritmo sinusal, alterações inespecíficas da repolarização ventricular', 'Alterações inespecíficas');
