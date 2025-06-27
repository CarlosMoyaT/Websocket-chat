package com.example.chatwebsocket.springboot_websocket_chat;

import com.example.chatwebsocket.springboot_websocket_chat.adapter.in.ChatController;
import com.example.chatwebsocket.springboot_websocket_chat.domain.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


class ChatControllerTest {

	@org.springframework.beans.factory.annotation.Autowired
	private ChatController chatController;

	@Test
	public void testReceiveMessage() {
		ChatController controller = new ChatController();
		Message input = new Message();
		input.setText("Hello im testing");

		Message result = controller.receiveMessage(input);

		assertNotNull(result); // testeamos que el mensaje no sea null
		assertNotNull(result.getDate()); // testeamos que la fecha ha sido agregada
		assertTrue(result.getDate() > 0); // testeamos que la fecha debe ser un timestamp válido
		assertEquals("Mensaje recibido: Hello im testing", result.getText()); //

	}

}
