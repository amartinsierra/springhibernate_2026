insert into escuela.alumno(dni,nombre,email,edad)values
('000000A1','Cristiano RONALDO','cr7@gmail.com',40),
('000000A2','Sergio Ramos','ramos@gmail.com',40),
('000000A3','Pepe','pepe@gmail.com',40);

insert into escuela.curso(codCurso,denominacion,duracion,horario)values
(001,'SpringMvc',300,'T'),
(002,'Microservicios',400,'T'),
(003,'Angular',300,'T');

insert into escuela.matricula(idAlumno,codCurso)values
('000000A1',001),
('000000A1',003),
('000000A2',003),
('000000A2',002),
('000000A3',001),
('000000A3',002);


