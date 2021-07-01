use std::iter::FromIterator;

#[derive(Default)]
pub struct SimpleLinkedList<T> {
    head: Option<Box<Node<T>>>,
}

#[derive(Clone)]
struct Node<T> {
    data: T,
    next: Option<Box<Node<T>>>,
}

impl<T: Default + Clone> SimpleLinkedList<T> {
    pub fn new() -> Self {
        Default::default()
    }

    pub fn is_empty(&self) -> bool {
        self.head.is_none()
    }

    pub fn len(&self) -> usize {
        let mut node_opt = &self.head;
        let mut len = 0;
        while let Some(node) = node_opt {
            len += 1;
            node_opt = &node.next;
        }
        len
    }

    pub fn push(&mut self, element: T) {
        self.head = Some(Box::new(Node {
            data: element,
            next: self.head.clone(),
        }))
    }

    pub fn pop(&mut self) -> Option<T> {
        match self.head.clone() {
            None => None,
            Some(node) => {
                self.head = node.next.clone();
                Some(node.data.clone())
            }
        }
    }

    pub fn peek(&self) -> Option<&T> {
        self.head.as_ref().map(|h| &h.data)
    }

    pub fn rev(self) -> SimpleLinkedList<T> {
        let mut vec: Vec<T> = Vec::new();
        let mut node_opt = &self.head;
        while let Some(node) = node_opt {
            vec.push(node.data.clone());
            node_opt = &node.next;
        }
        SimpleLinkedList::from_iter(vec)
    }
}

impl<T: Default + Clone> FromIterator<T> for SimpleLinkedList<T> {
    fn from_iter<I: IntoIterator<Item=T>>(iter: I) -> Self {
        let mut list = SimpleLinkedList::new();
        for el in iter {
            list.push(el);
        }
        list
    }
}

impl<T: Clone> Into<Vec<T>> for SimpleLinkedList<T> {
    fn into(self) -> Vec<T> {
        let mut vec: Vec<T> = Vec::new();
        let mut node_opt = &self.head;
        while let Some(node) = node_opt {
            vec.push(node.data.clone());
            node_opt = &node.next;
        }
        vec.reverse();
        vec
    }
}