package module12DevSpringCore;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.NoSuchElementException;


import java.util.*;

@Service
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>();

    //метод повертає список всіх нотаток
    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    //метод додає нову нотатку
    public Note add(Note note) {
        if (notes.isEmpty()) {
            note.setId(1L);
        } else {
            note.setId(notes.keySet().stream().max(Long::compareTo).orElse(0L) + 1);
        }
        return notes.put(note.getId(), note);
    }
 //видаляє нотатку з вказаним ідентифікатором.
    public void deleteById(long id) {
        if (notes.containsKey(id)) {
            notes.remove(id);
        } else {
            throw new NoSuchElementException();
        }
    }
    //шукає нотатку по note.id
    public void update(Note note) {
        if (notes.containsKey(note.getId())) {
            notes.put(note.getId(), note);
        } else {
            throw new NoSuchElementException();
        }
    }

    public Note getById(long id) {
        return Optional.ofNullable(notes.get(id))
                .orElseThrow(NoSuchElementException::new);
    }
}
