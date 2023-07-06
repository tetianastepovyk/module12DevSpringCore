package module12DevSpringCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module12DevSpringCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(Module12DevSpringCoreApplication.class, args);

		NoteService noteService = new NoteService();
		Note note1 = Note.builder().id(1).title("Title1").content("Client1").build();
		Note note2 = Note.builder().id(2).title("Title2").content("Client2").build();
		Note note3 = Note.builder().id(3).title("Title3").content("Client3").build();
		noteService.add(note1);
		noteService.add(note2);
		noteService.add(note3);
		System.out.println("List of all notes: " +noteService.listAll());

		Note updatedNote = Note.builder().id(1).title("Title5").content("Client5").build();
		noteService.update(updatedNote);
		System.out.println("UpdateList of all notes: " +noteService.listAll());

		noteService.deleteById(2);
		System.out.println("UpdateList of all notes after delete Note by id 2: " +noteService.listAll());

		System.out.println("a note by Id 1: " +noteService.getById(1));

	}
}
