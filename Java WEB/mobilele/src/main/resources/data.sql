INSERT INTO users(id, email, first_name, is_active, last_name, password, username)
VALUES
    (1, 'robertospasovrs@gmail.com', 'Roberto', 1, 'Spasov', '112df92e938a12fc18a2fb2c26805b893a6ae768f7220fd1833681925570de944e0123ce587dddb9dac98bd76fc8f212', 'Rober70'),
    (2, 'user@gmail.com', 'user', 1, 'Spasov', '112df92e938a12fc18a2fb2c26805b893a6ae768f7220fd1833681925570de944e0123ce587dddb9dac98bd76fc8f212', 'RS');

INSERT INTO user_roles(id, role)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO brands(id, brand_name)
VALUES
    (1, 'Trabant'),
    (2, 'Jigula'),
    (3, 'Lada');

INSERT INTO models(id, model_name, category, brand_id, image_url)
VALUES
    (1, '601','CAR' , 1, 'https://www.autoscout24.bg/cms-content-assets/ofx9265tkP0tokDWbcvyT-5974b71ed84f16b4932762a0807e8780-trabant-l-1100.jpg'),
    (2, 'Jigi','CAR' , 2, 'https://upload.wikimedia.org/wikipedia/commons/e/e5/1980_-_VAZ_2101.JPG'),
    (3, '1600s','CAR' , 3, 'https://cdn4.focus.bg/fakti/photos/big/3a3/55-hil-evro-za-lada-1.jpg');

INSERT INTO users_user_roles(user_id, role_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);