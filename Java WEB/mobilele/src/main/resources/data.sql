INSERT INTO users(id, email, first_name, is_active, last_name, password, username)
VALUES
    (1, 'robertospasovrs@gmail.com', 'Roberto', 1, 'Spasov', '112df92e938a12fc18a2fb2c26805b893a6ae768f7220fd1833681925570de944e0123ce587dddb9dac98bd76fc8f212', 'Rober70'),
    (2, 'user@gmail.com', 'user', 1, 'Spasov', '112df92e938a12fc18a2fb2c26805b893a6ae768f7220fd1833681925570de944e0123ce587dddb9dac98bd76fc8f212', 'Rober70');

INSERT INTO user_roles(id, role)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');


INSERT INTO users_user_roles(user_id, role_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);