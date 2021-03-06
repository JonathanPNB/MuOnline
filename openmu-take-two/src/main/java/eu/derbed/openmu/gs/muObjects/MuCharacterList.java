package eu.derbed.openmu.gs.muObjects;

import eu.derbed.util.LoggableObject;

/**
 *
 */

/**
 * @author MikiOne
 *
 */
public class MuCharacterList extends LoggableObject {

	private static final int MAXIMUM_NUMBER_OF_CHARACTERS = 5;

	//	AAA merge with chlistdb
	private boolean _needRead = true;
	private final MuCharacterBase[] _chars = { null, null, null, null, null };

	/**
	 * get character base fron name
	 *
	 * @param _name
	 *            to get
	 * @return character base
	 */
	public MuCharacterBase getChar(final String _name) {
		for (final MuCharacterBase muCharacterBase : _chars) {
			if (muCharacterBase != null) {
				if (muCharacterBase.getName().compareTo(_name) == 0) {
					return muCharacterBase;
				}
			}
		}
		return null;
	}

	/**
	 *
	 * @return firs free slot
	 */
	public byte getFirstFreeSlot() {
		byte i;
		for (i = 0; i < 5; i++) {
			if (_chars[i] == null) {
				break;
			}
		}
		return i;
	}

	public boolean addNew(final MuCharacterBase c) {
		final int count = getCharsCount();
		if (count >= 5) {
			return false;
		}
		final byte i = getFirstFreeSlot();
		log.info("Added new character '{}' in slot {}", c.getName(), i);
		_chars[i] = c;
		return true;
	}

	public boolean removeChar(final String name) {
		byte i;
		for (i = 0; i < 5; i++) {
			if (name.equalsIgnoreCase(_chars[i].getName())) {
				break;
			}
		}
		if (i < 5) {
			_chars[i] = null;
			return true;
		} else {
			return false;
		}
	}

	public MuCharacterBase getChar(final int nr) {
		return _chars[nr];
	}

	public int getCharsCount() {
		int count = 0;
		for (byte i = 0; i < 5; i++) {
			if (_chars[i] != null) {
				count++;
			}
		}
		return count;
	}

	/**
	 * @return
	 */
	public boolean isFull() {
		return MAXIMUM_NUMBER_OF_CHARACTERS == getCharsCount();
	}

	public boolean needRead() {
		return _needRead;
	}

	public void noNeedRead() {
		_needRead = false;
	}
}
